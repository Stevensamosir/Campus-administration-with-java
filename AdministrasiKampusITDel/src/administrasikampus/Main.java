package administrasikampus;

//impor lib yang dibutuhkan 

import java.io.*; 
import java.util.*;
 
//deklarasi class utama 
public class Main{ 
  public static void menuAwal(){
      System.out.println("\n-- SELAMAT DATANG --");
      System.out.println("1. Login Sebagai Admin");
      System.out.println("2. Login Sebagai Mahasiswa ");
      System.out.println("3. Daftar");
      System.out.println("0. Berhenti");
      System.out.println(">>>Masukkan pilihan anda : ");
  }    
  public static void menuUtamaAdmin(){
      System.out.println("\n=== SELAMAT DATANG DI SISTEM ADMINISTRASI KAMPUS IT DEL ===");
      System.out.println("1. Layanan Surat");
      System.out.println("2. Data Mahasiswa");
      System.out.println("3. Pengumuman");
      System.out.println("4. Aspirasi Mahasiswa");
      System.out.println("5. Data Member");
      System.out.println("0. Keluar");
      System.out.println(">>>Masukkan pilihan anda : ");
  }  
  public static void menuUtamaMember(){
      System.out.println("\n=== SELAMAT DATANG DI SISTEM LAYANAN ADMINISTRASI KAMPUS IT DEL ===");
      System.out.println("1. Layanan Surat");
      System.out.println("2. Pengumuman");
      System.out.println("3. Aspirasi Mahasiswa");
      System.out.println("0. Keluar");
      System.out.println(">>>Masukkan pilihan anda : ");
  }  
  public static void layananSurat(){
      System.out.println("1. Surat Pengantar Magang");
      System.out.println("2. Surat Keterangan Lulus");
      System.out.println("3. Surat Pengganti KTM");
      System.out.println("4. Surat IK");
      System.out.println("5. Surat IB");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuTambahan(){
      System.out.println("1. Tambah Data");
      System.out.println("2. Ubah Data");
      System.out.println("3. Hapus Data");
      System.out.println("4. Lihat Semua Data");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuSurat(){
      System.out.println("1. Request Surat");
      System.out.println("2. Riwayat Surat Anda");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuSuratAdmin(){
      System.out.println("1. Konfirmasi Surat Satu Persatu");
      System.out.println("2. Konfirmasi Semua Surat Sekaligus");
      System.out.println("3. Daftar Surat");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void konfirmasi(){
        System.out.println("\nPilih Jenis Konfirmasi: \n"
            + "1. Terima\n"
            + "2. Tolak\n" );
  }
  
  
 public static void main(String[] args){ 
    //create folder
    File folder = new File("Data SAD");
    folder.mkdir(); //create folder "Data SAD"
    
    
    //deklarasi untuk masukan user
    BufferedWriter save, saveUpd, saveDel; 
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); 
    Scanner input = new Scanner(System.in); //membuat variabel untuk menerima inputan user
    
    //variabel
    int menuAwal, menuUtama, menuTambahan, layananSurat, admin=0, member=0; 
    String usernameAdmin = "admin", passwordAdmin = "admin";
    String memberTemp, memberNow="";
    
    try{
        do{
            menuAwal();
            menuAwal = input.nextInt();

            if(menuAwal == 1){
                System.out.println(""); 
                System.out.print("Masukkan username: "); 
                String username = scan.readLine(); 
                System.out.print("Masukkan password: "); 
                String password = scan.readLine();  
                
                ArrayList<String> listAdminTxt = new ArrayList<>(); //List menampung dari txt file
                try{
                    File data = new File ("Data SAD/Admin.txt"); //Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                    listAdminTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                    while(getData.hasNextLine()) { //membaca seluruh isi file
                        listAdminTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                    }
                    
                    //mencetak data 
                    for (int i=0; i<listAdminTxt.size(); i++){
                        if(listAdminTxt.get(i).split(",")[0].split(": ")[1].equals(username) && listAdminTxt.get(i).split(",")[1].split(": ")[1].equals(password)){
                            admin = 1;
                            break;
                        }
                    }
                    listAdminTxt.clear(); 
                    
                    // Memeriksa apakah objek admin adalah instance dari BerhasilMasukInterface
                    if (admin == 1) {
                        // Membuat objek Admin dan memanggil metode printBerhasilMasuk()
                        Admin<String> adminObject = new Admin<>(username, password);
                        adminObject.BerhasilMasuk();
                        break;
                    } else {
                        Admin<String> adminObject = new Admin<>(username, password);
                        adminObject.GagalMasuk();
                    }
                }
                catch(IOException e){
                } 
            }
            
            else if(menuAwal == 2) {
                System.out.print("\nMasukkan username: "); 
                String username = input.next();
                System.out.print("Masukkan password: "); 
                String password = scan.readLine();  
                
                ArrayList<String> listMemberTxt = new ArrayList<>(); // List menampung dari txt file
                try {
                    File data = new File ("Data SAD/Member.txt"); // Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); // Untuk membaca data dari file 
            
                    listMemberTxt.clear(); // Menghapus list, agar ketika list dipanggil ulang, elemen tidak bertindih
                    while(getData.hasNextLine()) { // Membaca seluruh isi file
                        listMemberTxt.add(getData.nextLine()); // Save data dari txt file ke ArrayList
                    }
                    
                    // Mencetak data 
                    for (int i=0; i<listMemberTxt.size(); i++) {
                        if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) 
                                && listMemberTxt.get(i).split(",")[5].split(": ")[1].equals(password)){
                            member = 1;
                            memberTemp = listMemberTxt.get(i).split(",")[4];
                            memberNow = memberTemp.split(": ")[1];
                            break;
                        }
                    }
                    listMemberTxt.clear(); 
                    
                    if (member == 1) {
                        // Membuat objek Member dan memanggil metode berhasilMasuk()
                        Member<String> memberObject = new Member<>(memberNow, "Email Member", "Gender Member", "Alamat Member", username, "Password Member");
                        memberObject.BerhasilMasuk();
                        break;
                    } else {
                        Member<String> memberObject = new Member<>("Nama Member", "Email Member", "Gender Member", "Alamat Member", "Username Member", "Password Member");
                        memberObject.GagalMasuk();
                    }
                    
                } catch(IOException e) {
                    e.printStackTrace();
                } 
            }
            
            
            
            else if(menuAwal == 3){
                System.out.println(""); 
                System.out.println("Masukkan data diri anda : ");
                System.out.print("Nama: "); 
                String nama = scan.readLine(); 
                System.out.print("Email: "); 
                String email = scan.readLine(); 
                System.out.print("Gender: "); 
                String gender = scan.readLine(); 
                System.out.print("Alamat: "); 
                String alamat = scan.readLine(); 
                System.out.print("Username: "); 
                String username = scan.readLine(); 
                System.out.print("Password: "); 
                String password = scan.readLine();
                
                ArrayList<String> listMemberTxt = new ArrayList<>(); //List menampung dari txt file
                try{
                    File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                    listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                    while(getData.hasNextLine()) { //membaca seluruh isi file
                        listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                    }

                    //cek apakah inputan sama dengan yang terdaftar
                    int temp=0;
                    for (int i=0; i<listMemberTxt.size(); i++){
                        if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) || listMemberTxt.get(i).split(",")[1].split(": ").equals(password)){
                            temp = 1;
                        }
                    }
                    listMemberTxt.clear(); 
                    
                    if(temp == 1){
                        System.out.println(">>>Maaf, Username/Email Sudah Pernah Terdaftar");
                        break;
                    }
                    
                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan

                    Member dataMember = new Member(nama, email, gender, alamat, username, password);

                    save.write(dataMember.toString()); //save data ke txt dalam format toString
                    save.newLine(); 
                    save.close(); //close I/O
                    System.out.println(">>>Daftar Berhasil");
                }catch(IOException e){ 
                } 
            } 
        }
        while(menuAwal != 0);
        
    
    
    
        //Menu Lanjutan setelah berhasil login ke sistem
        if(admin == 1){      
            do{
                menuUtamaAdmin();
                menuUtama = input.nextInt();
                switch(menuUtama){
                    case 1:
                        do{
                            System.out.println("\nMenu Lanjutan Layanan Surat");
                            layananSurat();
                            layananSurat = input.nextInt();
                            int menuSuratAdmin=0;
                            
                            switch(layananSurat){
                                case 1: //surat kk
                                    ArrayList<String> listData_MahasiswaTxt = new ArrayList<>(); //List menampung dari txt file
                                    
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/Data_Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_MahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_MahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listData_MahasiswaTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listData_MahasiswaTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listData_MahasiswaTxt.get(i).split(",")[3].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listData_MahasiswaTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listData_MahasiswaTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listData_MahasiswaTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listData_MahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/Data_Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_MahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_MahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listData_MahasiswaTxt.size(); i++){
                                                        String sebelum = listData_MahasiswaTxt.get(i).split(",")[3].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listData_MahasiswaTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listData_MahasiswaTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listData_MahasiswaTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                    listData_MahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/Data_Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_MahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_MahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat KK");
                                                    for (int i=0; i<listData_MahasiswaTxt.size(); i++){
                                                        System.out.println(listData_MahasiswaTxt.get(i));
                                                    }
                                                    listData_MahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 2: //surat ktp
                                    ArrayList<String> listData_LulusTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/Data_Lulus.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_LulusTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_LulusTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listData_LulusTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listData_LulusTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listData_LulusTxt.get(i).split(",")[1].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listData_LulusTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listData_LulusTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listData_LulusTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listData_LulusTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/Data_Lulus.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_LulusTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_LulusTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listData_LulusTxt.size(); i++){
                                                        String sebelum = listData_LulusTxt.get(i).split(",")[1].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listData_LulusTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listData_LulusTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listData_LulusTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listData_LulusTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/Data_Lulus.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_LulusTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_LulusTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat KTP");
                                                    for (int i=0; i<listData_LulusTxt.size(); i++){
                                                        System.out.println(listData_LulusTxt.get(i));
                                                    }
                                                    listData_LulusTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                        
                                case 3: //surat domisili
                                    ArrayList<String> listKTMTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/KTM.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKTMTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKTMTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listKTMTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listKTMTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listKTMTxt.get(i).split(",")[2].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listKTMTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKTMTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKTMTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listKTMTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/KTM.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKTMTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKTMTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listKTMTxt.size(); i++){
                                                        String sebelum = listKTMTxt.get(i).split(",")[2].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listKTMTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKTMTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKTMTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listKTMTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/KTM.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKTMTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKTMTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat Domisili");
                                                    for (int i=0; i<listKTMTxt.size(); i++){
                                                        System.out.println(listKTMTxt.get(i));
                                                    }
                                                    listKTMTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 4: //surat tidak mampu
                                    ArrayList<String> listIKTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/IK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listIKTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listIKTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listIKTxt.get(i).split(",")[2].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listIKTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listIKTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listIKTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listIKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/IK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listIKTxt.size(); i++){
                                                        String sebelum = listIKTxt.get(i).split(",")[2].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listIKTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listIKTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listIKTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listIKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/IK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat IK");
                                                    for (int i=0; i<listIKTxt.size(); i++){
                                                        System.out.println(listIKTxt.get(i));
                                                    }
                                                    listIKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 5: //surat migrasi
                                    ArrayList<String> listIBTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/IB.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIBTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIBTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listIBTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listIBTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listIBTxt.get(i).split(",")[4].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listIBTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listIBTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listIBTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listIBTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/IB.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIBTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIBTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listIBTxt.size(); i++){
                                                        String sebelum = listIBTxt.get(i).split(",")[4].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listIBTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listIBTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listIBTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listIBTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/IB.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIBTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIBTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat IB");
                                                    for (int i=0; i<listIBTxt.size(); i++){
                                                        System.out.println(listIBTxt.get(i));
                                                    }
                                                    listIBTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                            }
                        }while(layananSurat != 0);
                        break;
                        
                    case 2: //Menu untuk mengelola data Mahasiswa
                        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listMahasiswaTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Mahasiswa Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    try{
                                        System.out.println("\nMasukkan Data Mahasiswa: ");
                                        System.out.print("NIM: "); 
                                            String nim = scan.readLine(); 
                                        System.out.print("Nama: "); 
                                            String nama = scan.readLine(); 
                                        System.out.print("Gender: "); 
                                            String gender = scan.readLine(); 
                                        System.out.print("Tempat Lahir: "); 
                                            String tempat_lahir = scan.readLine(); 
                                        System.out.print("Tanggal Lahir: "); 
                                            String tanggal_lahir = scan.readLine(); 
                                        System.out.print("Golongan Darah: "); 
                                            String gol_darah = scan.readLine(); 
                                        System.out.print("Agama: "); 
                                            String agama = scan.readLine(); 
                                        System.out.print("Program Studi: "); 
                                            String program_studi = scan.readLine(); 
                                        System.out.print("Nama Ayah: "); 
                                            String nama_ayah = scan.readLine();     
                                        System.out.print("Nama Ibu: "); 
                                            String nama_ibu = scan.readLine();     
                                    
                                        listMahasiswa.clear(); //hapus list utk menghindari data bertindih
                                        listMahasiswa.add(new Mahasiswa( nim, nama, gender, tempat_lahir, tanggal_lahir, gol_darah, agama, program_studi, nama_ayah, nama_ibu));
                                        for (Mahasiswa list : listMahasiswa) {
                                            try{
                                                File data = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                save.write(list.toString()); //save data ke txt dalam format toString
                                                save.newLine();
                                                save.close(); //close I/O
                                                System.out.println(">>>Tambah Data Berhasil");
                                            }
                                            catch(IOException e){
                                            }
                                        }
                                    }
                                    catch(IOException e){
                                    }
                                    listMahasiswa.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMahasiswaTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMahasiswaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listMahasiswaTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Mahasiswa: ");
                                                    System.out.print("NIM: "); 
                                                        String nimUpd = scan.readLine(); 
                                                    System.out.print("Nama: "); 
                                                        String namaUpd = scan.readLine(); 
                                                    System.out.print("Gender: "); 
                                                        String genderUpd = scan.readLine(); 
                                                    System.out.print("Tempat Lahir: "); 
                                                        String tempat_lahirUpd = scan.readLine(); 
                                                    System.out.print("Tanggal Lahir: "); 
                                                        String tanggal_lahirUpd = scan.readLine(); 
                                                    System.out.print("Golongan Darah: "); 
                                                        String gol_darahUpd = scan.readLine(); 
                                                    System.out.print("Agama: "); 
                                                        String agamaUpd = scan.readLine(); 
                                                    System.out.print("Program Studi: "); 
                                                        String program_studiUpd = scan.readLine(); 
                                                    System.out.print("Nama Ayah: "); 
                                                        String nama_ayahUpd = scan.readLine();     
                                                    System.out.print("Nama Ibu: "); 
                                                        String nama_ibuUpd = scan.readLine();
                                                    
                                                    listMahasiswa.clear();
                                                    listMahasiswa.add( new Mahasiswa(nimUpd, namaUpd, genderUpd, tempat_lahirUpd, tanggal_lahirUpd, gol_darahUpd, agamaUpd,program_studiUpd, nama_ayahUpd, nama_ibuUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Mahasiswa list : listMahasiswa){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listMahasiswaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listMahasiswaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMahasiswaTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMahasiswaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listMahasiswaTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listMahasiswaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listMahasiswaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Mahasiswa:");
                                        for (int i=0; i<listMahasiswaTxt.size(); i++){
                                            System.out.println(listMahasiswaTxt.get(i));
                                        }
                                        listMahasiswaTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        
                        
                    case 3://Menu untuk mengelola data berita
                        ArrayList<Berita> listBerita = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listBeritaTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Berita Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Berita: ");
                                    System.out.print("Topik Berita: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Berita: "); 
                                        String deskripsi = scan.readLine(); 
                                    System.out.print("Tanggal Kirim: "); 
                                        String tanggal_kirim = scan.readLine(); 
                                    
                                    listBerita.clear(); //hapus list utk menghindari data bertindih
                                    listBerita.add(new Berita(topik, deskripsi, tanggal_kirim));
                                    for (Berita list : listBerita) {
                                        try{
                                            File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();              save.close(); //close I/O
                                            System.out.println(">>>Tambah Data Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listBerita.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listBeritaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listBeritaTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Berita: ");
                                                    System.out.print("Topik Berita: "); 
                                                        String topikUpd = scan.readLine(); 
                                                    System.out.print("Deskripsi Berita: "); 
                                                        String deskripsiUpd = scan.readLine(); 
                                                    System.out.print("Tanggal Kirim: "); 
                                                        String tanggal_kirimUpd = scan.readLine(); 
                                                    
                                                    listBerita.clear();
                                                    listBerita.add( new Berita(topikUpd, deskripsiUpd, tanggal_kirimUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Berita list : listBerita){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listBeritaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listBeritaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listBeritaTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listBeritaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Berita:");
                                        for (int i=0; i<listBeritaTxt.size(); i++){
                                            System.out.println(listBeritaTxt.get(i));
                                        }
                                        listBeritaTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        
                    
                    case 4://Menu untuk mengelola data saran/komentar
                        ArrayList<Saran> listSaran = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listSaranTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Saran Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Saran/Komentar Baru: ");
                                    System.out.print("Topik Saran/Komentar: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                        String saran = scan.readLine(); 
                                    System.out.print("Tanggal Pembuatan: "); 
                                        String tanggal = scan.readLine(); 
                                    
                                    listSaran.clear(); //hapus list utk menghindari data bertindih
                                    listSaran.add(new Saran(topik, saran, tanggal));
                                    for (Saran list : listSaran) {
                                        try{
                                            File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();              save.close(); //close I/O
                                            System.out.println(">>>Tambah Saran Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listSaran.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Saran Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listSaranTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listSaranTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Saran? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Saran Baru: ");
                                                    System.out.print("Topik Saran/Komentar: "); 
                                                        String topikUpd = scan.readLine(); 
                                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                                        String saranUpd = scan.readLine();  
                                                    System.out.print("Tanggal Pembuatan: "); 
                                                        String tanggalUpd = scan.readLine();  
                                                    
                                                    listSaran.clear();
                                                    listSaran.add( new Saran(topikUpd, saranUpd, tanggalUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Saran list : listSaran){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Saran");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listSaranTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Saran Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listSaranTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listSaranTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Saran");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listSaranTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Saran/Komentar:");
                                        for (int i=0; i<listSaranTxt.size(); i++){
                                            System.out.println(listSaranTxt.get(i));
                                        }
                                        listSaranTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        

                    case 5: //Menu untuk mengelola data member
                        ArrayList<Member> listMember = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listMemberTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Member Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            int temp=0;
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Member: ");
                                    System.out.print("Nama: "); 
                                        String nama = scan.readLine(); 
                                    System.out.print("Email: "); 
                                        String email = scan.readLine(); 
                                    System.out.print("Gender: "); 
                                        String gender = scan.readLine(); 
                                    System.out.print("Alamat: "); 
                                        String alamat = scan.readLine(); 
                                    System.out.print("Username: "); 
                                        String username = scan.readLine(); 
                                    System.out.print("Password: "); 
                                        String password = scan.readLine();
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                        listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //cek apakah inputan sama dengan yang terdaftar
                                        for (int i=0; i<listMemberTxt.size(); i++){
                                            if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) || listMemberTxt.get(i).split(",")[1].split(": ").equals(password)){
                                                temp = 1;
                                            }
                                        }
                                        listMemberTxt.clear(); 

                                        if(temp == 1){
                                            System.out.println(">>>Maaf, Username/Email Sudah Pernah Terdaftar");
                                            break;
                                        }
  
                                        Member dataMember = new Member(nama, email, gender, alamat, username, password);
                                        save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                        save.write(dataMember.toString()); //save data ke txt dalam format toString
                                        save.newLine(); 
                                        save.close(); //close I/O
                                        System.out.println(">>>Daftar Berhasil");
                                    }catch(IOException e){ 
                                    } 
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMemberTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listMemberTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Member: ");
                                                    System.out.print("Nama: "); 
                                                    String namaUpd = scan.readLine(); 
                                                    System.out.print("Email: "); 
                                                    String emailUpd = scan.readLine(); 
                                                    System.out.print("Gender: "); 
                                                    String genderUpd = scan.readLine(); 
                                                    System.out.print("Alamat: "); 
                                                    String alamatUpd = scan.readLine(); 
                                                    System.out.print("Username: "); 
                                                    String usernameUpd = scan.readLine(); 
                                                    System.out.print("Password: "); 
                                                    String passwordUpd = scan.readLine();
                                                    
                                                    listMember.clear();
                                                    listMember.add( new Member(namaUpd, emailUpd, genderUpd, alamatUpd, usernameUpd, passwordUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Member list : listMember){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listMemberTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMemberTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listMemberTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listMemberTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Member:");
                                        for (int i=0; i<listMemberTxt.size(); i++){
                                            System.out.println(listMemberTxt.get(i));
                                        }
                                        listMemberTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                
                
                
                }
            }
            while (menuUtama != 0);
        
        }
        
        
        
        else if(member == 1){
            do{
                menuUtamaMember();
                menuUtama = input.nextInt();
                
                switch(menuUtama){
                    case 1: //menu layanan Pemgamtar Magang
                        int menuSurat, temp=0;
                        ArrayList<String> listMahasiswaTxt = new ArrayList<>(); //List menampung dari txt file 
                        do{
                            System.out.println("\nMenu Lanjutan Layanan Surat");
                            layananSurat();
                            layananSurat = input.nextInt();
                            
                            switch(layananSurat){
                                case 1: //surat ket Data_Mahasiswa
                                    ArrayList<String> listData_MahasiswaTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan Nim:");
                                                    String nim = scan.readLine(); 
                                                System.out.println("Masukkan Nama:");
                                                    String nama = scan.readLine(); 
                                                System.out.println("Masukkan Prodi");
                                                    String program_studi = scan.readLine();
                                                    
                                                try{
                                                    File data = new File ("Data SAD/Data_Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listData_MahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_MahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nim yang direquest terdaftar
                                                    for (int i=0; i<listData_MahasiswaTxt.size(); i++){
                                                        if(listData_MahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nim) || listData_MahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nama)){
                                                            Data_Mahasiswa dm = new Data_Mahasiswa( nim,  nama, program_studi, StatusRequest.Diminta, memberNow); 
                                                            save.write(dm.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Pengantar Magang Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal, NIM  belum terdaftar dalam sistem");
                                                    }
                                                    listMahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/Data_Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_MahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_MahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Pengantar Magang oleh Member : " + memberNow );
                                                    for (int i=0; i<listData_MahasiswaTxt.size(); i++){
                                                        if(listData_MahasiswaTxt.get(i).split(",")[4].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listData_MahasiswaTxt.get(i).split(",")[0] + "," 
                                                               + listData_MahasiswaTxt.get(i).split(",")[1] + "," 
                                                               + listData_MahasiswaTxt.get(i).split(",")[2] + "," 
                                                               + listData_MahasiswaTxt.get(i).split(",")[3] 
                                                            );
                                                        }
                                                    }
                                                    listData_MahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                    case 2: //surat ket Lulus
                                    ArrayList<String> listData_LulusTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan Nim:");
                                                    String nim = scan.readLine(); 
                                                System.out.println("Masukkan Nama:");
                                                    String nama = scan.readLine(); 
                                                System.out.println("Masukkan Prodi");
                                                    String program_studi = scan.readLine();
                                                try{
                                                    File data = new File ("Data SAD/Data_Lulus.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file Mahasiswa
                                                    
                                                    listMahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nim yang direquest terdaftar
                                                    for (int i=0; i<listMahasiswaTxt.size(); i++){
                                                        if(listMahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nim)){
                                                            Data_Lulus skl = new Data_Lulus( nim,nama,program_studi, StatusRequest.Diminta, memberNow); 
                                                            save.write(skl.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Keterangan Lulus Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIM belum terdaftar dalam sistem");
                                                    }
                                                    listMahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;

                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/Data_Lulus.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listData_LulusTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listData_LulusTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                     //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Keterangan Lulus oleh Mahasiswa : " + memberNow );
                                                    for (int i = 0; i < listData_LulusTxt.size(); i++) {
                                                        String[] splitData = listData_LulusTxt.get(i).split(",");
                                                        if (splitData.length >= 5 && splitData[4].contains(": ") && splitData[4].split(": ")[1].equals(memberNow)) {
                                                            System.out.println(splitData[0] + "," + splitData[1] + "," + splitData[2] + "," + splitData[3]);
                                                        }
                                                    }

                                                    listData_LulusTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 3: //surat Pengganti KTM
                                    ArrayList<String> listKTMTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIM Mahasiswa Bersangkutan:");
                                                    String nik = scan.readLine(); 
                                                System.out.println("Masukkan Alasan Pengurusan Surat:");
                                                    String tujuan = scan.readLine(); 
                                                
                                                try{
                                                    File data = new File ("Data SAD/KTM.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file Mahasiswa
                                                    
                                                    listMahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listMahasiswaTxt.size(); i++){
                                                        if(listMahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nik)){
                                                            KTM ktm = new KTM(tujuan, nik, StatusRequest.Diminta, memberNow); 
                                                            save.write(ktm.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Pengganti KTM Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIM belum terdaftar dalam sistem");
                                                    }
                                                    listMahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/KTM.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKTMTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKTMTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Pengganti KTM oleh Member : " + memberNow );
                                                    for (int i=0; i<listKTMTxt.size(); i++){
                                                        if(listKTMTxt.get(i).split(",")[3].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listKTMTxt.get(i).split(",")[0] + "," 
                                                               + listKTMTxt.get(i).split(",")[1] + "," 
                                                               + listKTMTxt.get(i).split(",")[2] 
                                                            );
                                                        }
                                                    }
                                                    listKTMTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 4: //surat IK
                                    ArrayList<String> listIKTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIM Mahasiswa Bersangkutan:");
                                                    String nim = scan.readLine(); 
                                                System.out.println("Masukkan keperluan Pengurusan Surat IK:");
                                                    String keperluan = scan.readLine();
                                                System.out.println("Masukkan Tujuan Pengurusan Surat IK:");
                                                    String tujuan = scan.readLine(); 
                                                
                                                try{
                                                    File data = new File ("Data SAD/IK.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file Mahasiswa
                                                    
                                                    listMahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nim yang direquest terdaftar
                                                    for (int i=0; i<listMahasiswaTxt.size(); i++){
                                                        if(listMahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nim)){
                                                            IK ik = new IK( tujuan, keperluan, nim, StatusRequest.Diminta, memberNow); 
                                                            save.write(ik.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat IK Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIM belum terdaftar dalam sistem");
                                                    }
                                                    listMahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/IK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat IK oleh Mahasiswa : " + memberNow );
                                                    for (int i=0; i<listIKTxt.size(); i++){
                                                        if(listIKTxt.get(i).split(",")[3].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listIKTxt.get(i).split(",")[0] + "," 
                                                               + listIKTxt.get(i).split(",")[1] + "," 
                                                               + listIKTxt.get(i).split(",")[2] 
                                                            );
                                                        }
                                                    }
                                                    listIKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 5: //surat ket Pindah
                                    ArrayList<String> listIBTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIM Mahasiswa Bersangkutan:");
                                                    String nim = scan.readLine(); 
                                                System.out.println("Pergi:");
                                                    String pergi = scan.readLine(); 
                                                System.out.println("Kembali:");
                                                    String kembali = scan.readLine(); 
                                                System.out.println("Tujuan:");
                                                    String tujuan = scan.readLine(); 
                                                
                                                try{
                                                    File data = new File ("Data SAD/IB.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Mahasiswa.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file Mahasiswa
                                                    
                                                    listMahasiswaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMahasiswaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nim yang direquest terdaftar
                                                    for (int i=0; i<listMahasiswaTxt.size(); i++){
                                                        if(listMahasiswaTxt.get(i).split(",")[0].split(": ")[1].equals(nim)){
                                                            IB ib = new IB(nim, pergi, kembali, tujuan, StatusRequest.Diminta, memberNow); 
                                                            save.write(ib.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat IB Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. nim belum terdaftar dalam sistem");
                                                    }
                                                    listMahasiswaTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/IB.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listIBTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listIBTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat IB oleh Member : " + memberNow );
                                                    for (int i=0; i<listIBTxt.size(); i++){
                                                        if(listIBTxt.get(i).split(",")[5].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listIBTxt.get(i).split(",")[0] + "," 
                                                               + listIBTxt.get(i).split(",")[1] + "," 
                                                               + listIBTxt.get(i).split(",")[2] + "," 
                                                               + listIBTxt.get(i).split(",")[3] + "," 
                                                               + listIBTxt.get(i).split(",")[4] 
                                                            );
                                                        }
                                                    }
                                                    listIBTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                            }
                        }while(layananSurat != 0);
                        break;
                        
                    case 2: //menu berita lanjutan
                        ArrayList<String> listBeritaTxt = new ArrayList<>(); //List menampung dari txt file
                        try{
                            File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                            Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                            listBeritaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                            while(getData.hasNextLine()) { //membaca seluruh isi file
                                listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                            }

                            //mencetak data
                            System.out.println("\nDaftar Berita Saat Ini:");
                            for (int i=0; i<listBeritaTxt.size(); i++){
                                System.out.println(listBeritaTxt.get(i));
                            }
                            listBeritaTxt.clear(); 
                        }
                        catch(IOException e){
                        }
                        break;
                        
                    case 3: //menu saran/komentar lanjutan
                        int opsi=1;
                        ArrayList<Saran> listSaran = new ArrayList<>(); //List menampung sebelum disimpan ke txt file
                        ArrayList<String> listSaranTxt = new ArrayList<>(); //List menampung dari txt file
                        
                        do{
                            try{
                                File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                listSaranTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                while(getData.hasNextLine()) { //membaca seluruh isi file
                                    listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                }

                                //mencetak data
                                System.out.println("\nDaftar Saran/Komentar Saat Ini:");
                                for (int i=0; i<listSaranTxt.size(); i++){
                                    System.out.println(listSaranTxt.get(i));
                                }

                                System.out.println("\n>>>Mau Menambah Saran/Komentar Baru? [Tekan 1. Untuk Menambahkan, Lainnya Untuk Keluar]");
                                opsi = input.nextInt();
                                if(opsi == 1){
                                    System.out.println("\nMasukkan Saran/Komentar Baru: ");
                                    System.out.print("Topik Saran/Komentar: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                        String saran = scan.readLine(); 
                                    System.out.print("Tanggal Pembuatan: "); 
                                        String tanggal = scan.readLine(); 

                                    listSaran.clear(); //hapus list utk menghindari data bertindih
                                    listSaran.add(new Saran(topik, saran, tanggal));
                                    for (Saran list : listSaran) {
                                        try{
                                            File dataSaran = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(dataSaran, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Saran Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listSaran.clear();
                                }
                                listSaranTxt.clear(); 
                            }
                            catch(IOException e){
                            }
                        }while (opsi == 1);
                        break;
                        
                        
                }
            }while (menuUtama!=0);
        }

     
   
     
     
     


    }
    catch(InputMismatchException e){
        System.out.println(">>Maaf, Inputan Anda Salah--");
    } 
    catch(IOException e){
        System.out.println(">>>Maaf, Terjadi Kesalahan  Pada File");
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println(">>>Data yang Hendak ditampilkan diluar Batas");
    }
    System.out.println(""); 
    System.out.println("---Terimakasih Telah Datang Berkunjung---"); 
 }
}


