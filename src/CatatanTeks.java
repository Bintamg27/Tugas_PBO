public class CatatanTeks extends Catatan {

    public CatatanTeks(String judul, String isi) {
        super(judul, isi);
    }

    @Override
    public String formatkanCatatan() {
        return "Judul: " + judul + "\nIsi: " + isi + "\n";
    }
}
