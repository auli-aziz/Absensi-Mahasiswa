package proyek.gui.member;

public interface Loginable {
    boolean login(String id, String password);
    void logout();
    String getPageName();

}
