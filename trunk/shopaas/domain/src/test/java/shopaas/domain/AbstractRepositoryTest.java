package shopaas.domain;

import java.io.FileInputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
public class AbstractRepositoryTest {

	private static String TEST_DATA_FILE = "src/test/resources/dbunit-test-data.xml";

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DataSource dataSource;

	private DataSource getDataSource() {
		return this.dataSource;
	}

	@BeforeTransaction
	public void onSetUpInTransaction() throws Exception {
		logger.info("*** Inserting test data ***");
		// Use spring to get the datasource
		DataSource ds = getDataSource();
		Connection conn = ds.getConnection();
		try {
			IDatabaseConnection connection = new DatabaseConnection(conn);
			DatabaseOperation.CLEAN_INSERT.execute(connection,
					new FlatXmlDataSet(new FileInputStream(TEST_DATA_FILE),
							false));
		} finally {
			DataSourceUtils.releaseConnection(conn, ds);
			logger.info("*** Finished inserting test data ***");
		}
	}

	@AfterTransaction
	public void onTearDownInTransaction() throws Exception {
		// Delete the data
		DataSource ds = getDataSource();
		Connection conn = ds.getConnection();
		try {
			IDatabaseConnection connection = new DatabaseConnection(conn);
			DatabaseOperation.DELETE.execute(connection, new FlatXmlDataSet(
					new FileInputStream(TEST_DATA_FILE)));
		} finally {
			DataSourceUtils.releaseConnection(conn, ds);
			logger.info("*** Finished removing test data ***");
		}
	}

}