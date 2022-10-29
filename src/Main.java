import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    static void zipFiles(String path, String path1) {
        try (ZipOutputStream zout= new ZipOutputStream(new FileOutputStream(path));
        FileInputStream fis = new FileInputStream(path1)) {
            ZipEntry entry = new ZipEntry("note.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {System.out.println(ex.getMessage());}
    }
    static void saveGame(String path, GameProgress saveGame) {
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(saveGame);
        } catch (Exception ex) {System.out.println(ex.getMessage());}
    }


    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(3, 3,3,3);
        GameProgress game2 = new GameProgress(2,4,7,170);
        GameProgress game3 = new GameProgress(4,6,2,80);
        saveGame("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save1.dat", game1);
        saveGame("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save2.dat", game2);
        saveGame("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save3.dat", game3);
        zipFiles("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save1.zip", "C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save1.dat");
        zipFiles("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save2.zip", "C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save2.dat");
        zipFiles("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save3.zip", "C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save3.dat");
        File dir1 = new File("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save1.dat");
        if (dir1.delete()) {System.out.println("Файл удален");}
        File dir2 = new File("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save2.dat");
        if (dir2.delete()) {System.out.println("Файл удален");}
        File dir3 = new File("C:\\Users\\novoa\\IdeaProjects\\Core3.1\\Games\\savegames\\save3.dat");
        if (dir3.delete()) {System.out.println("Файл удален");}
    }
}
