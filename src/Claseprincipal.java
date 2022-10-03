import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Claseprincipal extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String name = file.toAbsolutePath().toString();

        if( name.endsWith(".txt") /* name.toLowerCase().endsWith(".txt") */) {
            Thread auxiliar = new Thread( new CountFiles(name) );
            auxiliar.start();
        }
        return super.visitFile(file, attrs);
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No se encuentra archivo:%30s%n", file.toString()) ;
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {
        long t1; //tiempo en contar las líneas de cada archivo (individual)
        long t2 = 0; //tiempo en contar las líneas en todos los archivos (total)
        long l1; //lineas para cada archivo (individual)
        long l2 = 0; //lineas para todos los archivos (total)

        if (args.length == 0){
            System.exit(0);
        }


        //inicar en este directorio
        Path startingDir = Paths.get(args[0]);

        // clase para procesar los archivos
        Claseprincipal contadorLineas = new Claseprincipal();

        // iniciar el recorrido de los archivos
        Files.walkFileTree(startingDir, contadorLineas);


    }
}
