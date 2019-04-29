import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleFilesRenamer {

    public static void main(String[] args) {

        boolean renameDirectory = false;
        boolean renameTest = false;

        Pattern p = Pattern.compile("\\w+|\\.\\w{2,4}$");

        for (String arg : args) {
            if (arg.contains("d")) {
                renameDirectory = true;
            }
            if (arg.contains("t")) {
                renameTest = true;
            }
        }

        try {

            File f = new File(".");
            File[] paths = f.listFiles();

            for (File path : paths) {

                if (path.isDirectory() && !renameDirectory) {
                    continue;
                }

                String filename = path.getName();
                Matcher m = p.matcher(filename);

                StringBuilder newName = new StringBuilder();

                while (m.find()) {
                    newName.append(m.group());
                    newName.append("_");
                }

                System.out.println(filename + " -> " + newName.toString().toLowerCase().trim());

                if (!renameTest) {
                    // do the renaming
                    // path.renameTo(new File(newName.toString()))
                }

            }

            // Scanner sc = new Scanner(System.in);
            // wantRename = sc.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
