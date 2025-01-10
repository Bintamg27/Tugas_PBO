public class CatatanKeamanan extends Catatan {
    private String emailAtauUsername;
    private String password;

    public CatatanKeamanan(String judul, String emailAtauUsername, String password) {
        super(judul, "Data keamanan disimpan");
        this.emailAtauUsername = emailAtauUsername;
        this.password = password;
    }

    @Override
    public String formatkanCatatan() {
        return "Judul: " + judul + "\nEmail/Username: " + emailAtauUsername + "\nPassword: " + password + "\n";
    }
}

