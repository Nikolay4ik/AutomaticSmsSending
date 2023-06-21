public class User {
    private  String name;
    private  String phone;

    public User() {
    }

    public User(String login, String password) {
        this.name = login;
        this.phone = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
