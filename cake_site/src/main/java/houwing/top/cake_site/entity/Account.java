package houwing.top.cake_site.entity;

public class Account {
    private int id;
    private String username;
    private String userpass;
    private String nickname;
    private int priority;
    private boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Account() {

    }

    public Account(int id, boolean lock) {
        this.id = id;
        this.lock = lock;
    }

    public Account(int priority) {
        this.priority = priority;
    }

    public Account(String username, String userpass, String nickname, int priority) {
        this.username = username;
        this.userpass = userpass;
        this.nickname = nickname;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", nickname='" + nickname + '\'' +
                ", priority=" + priority +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
