public abstract class Catatan {
    protected String judul;
    protected String isi;

    // Konstruktor
    public Catatan(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    // Metode abstrak untuk memformat catatan
    public abstract String formatkanCatatan();
}
