import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Sebuah class yang merupakan anak dari class Pekerja
 * 
 * @author Alphancoders
 * @version 2021.11.18
 */
public class Dokter extends Pekerja 
{

    // Fields
    private String nama;
    private String id;
    private AkunDokter dokter;

    /**
     * Sebuah method constructor
     * 
     * @throws IOException
     */
    public Dokter() throws IOException 
    {
        // Composition merupakan karakteristik OOP
        dokter = new AkunDokter();
    }

    /**
     * Sebuah method constructor dengan parameter
     * 
     * @param id
     * @throws IOException
     */
    public Dokter(String id) throws IOException 
    {
        this.id = id;
        // Menggunakan teknik komposisi
        dokter = new AkunDokter(id);
    }

    /**
     * Sebuah method setter yang ditimpa dari class Pekerja
     */
    @Override
    public void setPin(int pin) throws IOException 
    {
        dokter.setPin(pin);
    }

    /**
     * Sebuah method getter yang bertujuan untuk mendapakan pin untuk dokter
     */
    @Override
    public int getPin() throws IOException 
    {
        return dokter.getPin(id);
    }

    /**
     * Sebuah method getter untuk mendapatkan nama
     * 
     * @return this.nama
     */
    @Override
    public String getNama() throws IOException 
    {
        FileReader fileReader = new FileReader("DatabaseDokter.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // Membaca untuk satu baris
        String data = bufferedReader.readLine();
        // Mengambil data yang dipisahkan dengan koma dengan memakai fungsi delimiter
        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        // Membaca keseluruhan file
        while (data != null) {
            stringTokenizer = new StringTokenizer(data, ",");
            // Move to ID
            if (id.equals(stringTokenizer.nextToken())) {
                // Pindah pin
                stringTokenizer.nextToken();
                // Setelah dipindah didapatkan nama
                this.nama = stringTokenizer.nextToken();
                break;
            } else {
                // Membaca baris selanjutnya jika baris pertama tidak ada yg memenuhi syarat
                // yang diminta
                data = bufferedReader.readLine();
            }
        }
        bufferedReader.close();
        return this.nama;
    }
}