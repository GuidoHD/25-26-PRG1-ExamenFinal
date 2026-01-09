import java.util.Scanner;

class CalculadoraGeometriaExamen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] historial_f = new String[20];
        double[] historialArea = new double[20];
        double[] historialPerimetro = new double[20];
        int historialIndice = 0;

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while(true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int botonPresionado = scanner.nextInt();

            if (botonPresionado == 5) {
                System.out.println("Historial de Calculos");
                double totalArea = 0;
                for (int i = 0; i < historialIndice; i++) {
                    System.out.println((i+1) + ". " + historial_f[i] + " -> Area: " + historialArea[i] + ", Perimetro/Volumen: " + historialPerimetro[i]);
                    totalArea += historialArea[i];
                }
                System.out.println("Area total acumulada: " + totalArea);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double y = 0;
            double z = 0;
            boolean f = false;

            if (botonPresionado == 1) {
                System.out.print("Radio: ");
                y = scanner.nextDouble();
                if (y > 0) {
                    z = 3.14159 * y * y;
                    double p = 2 * 3.14159 * y;
                    System.out.println("Area: " + z);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(historialIndice < 20) {
                        historial_f[historialIndice] = "Circulo";
                        historialArea[historialIndice] = z;
                        historialPerimetro[historialIndice] = p;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (botonPresionado == 2) {
                System.out.print("Base: ");
                y = scanner.nextDouble();
                System.out.print("Altura: ");
                z = scanner.nextDouble();
                if (y > 0 && z > 0) {
                    double a = y * z;
                    double p = 2 * (y + z);
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(historialIndice < 20) {
                        historial_f[historialIndice] = "Rectangulo";
                        historialArea[historialIndice] = a;
                        historialPerimetro[historialIndice] = p;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (botonPresionado == 3) {
                System.out.print("Lado 1: ");
                y = scanner.nextDouble();
                System.out.print("Lado 2: ");
                z = scanner.nextDouble();
                System.out.print("Lado 3: ");
                double w = scanner.nextDouble();
                if (y > 0 && z > 0 && w > 0 && (y + z > w && y + w > z && z + w > y)) {
                    double s = (y + z + w) / 2;
                    double a = Math.sqrt(s * (s - y) * (s - z) * (s - w));
                    double p = y + z + w;
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(historialIndice < 20) {
                        historial_f[historialIndice] = "Triangulo";
                        historialArea[historialIndice] = a;
                        historialPerimetro[historialIndice] = p;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (botonPresionado == 4) {
                System.out.print("Radio: ");
                y = scanner.nextDouble();
                System.out.print("Altura: ");
                z = scanner.nextDouble();
                if (y > 0 && z > 0) {
                    double areaBase = 3.14159 * y * y;
                    double areaLateral = 2 * 3.14159 * y * z;
                    double areaTotal = 2 * areaBase + areaLateral;
                    double volumen = areaBase * z;
                    System.out.println("Area Superficial: " + areaTotal);
                    System.out.println("Volumen: " + volumen);
                    f = true;
                    if(historialIndice < 20) {
                        historial_f[historialIndice] = "Cilindro";
                        historialArea[historialIndice] = areaTotal;
                        historialPerimetro[historialIndice] = volumen;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }

            if (f) {
                System.out.println("Calculo completado.");
            }
        }
        scanner.close();
    }
}
