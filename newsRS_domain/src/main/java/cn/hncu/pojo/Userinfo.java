package cn.hncu.pojo;

public class Userinfo {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String email;

    private Integer phoneNumber;

    private String ismanager;

    private String isactivated;

    private String code;

    private String image;

    private String background;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsmanager() {
        return ismanager;
    }

    public void setIsmanager(String ismanager) {
        this.ismanager = ismanager == null ? null : ismanager.trim();
    }

    public String getIsactivated() {
        return isactivated;
    }

    public void setIsactivated(String isactivated) {
        this.isactivated = isactivated == null ? null : isactivated.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }
}