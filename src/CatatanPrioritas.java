public class CatatanPrioritas extends Catatan {
    private String prioritas;

    public CatatanPrioritas(String judul, String isi, String prioritas) {
        super(judul, isi);
        this.prioritas = prioritas;
    }

    @Override
    public String formatkanCatatan() {
        return "Judul: " + judul + "\nIsi: " + isi + "\nPrioritas: " + prioritas + "\n";
    }
}

