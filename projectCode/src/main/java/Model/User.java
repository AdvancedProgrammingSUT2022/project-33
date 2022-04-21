package Model;

public class User {
    private String nickname;
    private String username;
    private String password;





    ////methods////
    public User(String nickname, String username, String password)
    {
            this.nickname = nickname;
            this.username = username;
            this.password = password;
    }



    //getters
    public String getNickname() {
        return nickname;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }



    //setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
