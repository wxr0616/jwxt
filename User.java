package ceshi;

public class User {
	
    private String username;
    private Integer password;
    private String role;
    
    
    public String userSname() {
        return username;
    }
 
    public Integer getPassword() {
        return password;
    }
 
    public String getRole() {
        return role;
    }
    
    
    public void setUsername(String username) {
        this.username = username;
    }
 
    public void setPassword(Integer password) {
        this.password = password;
    }
 
    public void setRole(String role) {
        this.role=role;
    }
        
        public User(String username, Integer password, String role) {
            
            this.username = username;
            
            this.password = password;
            
            this.role = role;
        }
     
        public User() {
            super();
        }
     
        @Override
        public String toString() {
            return "User{" +
                    "username=" + username +
                    ",password='" + password + '\'' +
                    ", role='" + role + '\'' +
                    "}";
        }

		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
}
