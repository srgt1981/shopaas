package shopaas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    String id;
    
    @Column(unique=true)
    private String username;
    
    @Column
    private String name;
    
    @Column
    private String surname;

    public User(String username, String name, String surname) throws UserInitializationException {
        this.username = username;
        this.name = name;
        this.surname = surname;
        if ( username == null ) {
            throw new UserInitializationException("username is null");
        }
        if ( "".equals(username.trim())) {
            throw new UserInitializationException("username is empty");
        }
    }
    
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * Changing someone's name can have side effects.
     * 
     * @param name
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Changing someone's surname can have side effects.
     * 
     * @param surname
     */
    public void changeSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return this.id;
    }
    
    /**
     * Private constructor only for JPA-use. 
     */
    @SuppressWarnings("unused")
	private User() {    }


}

