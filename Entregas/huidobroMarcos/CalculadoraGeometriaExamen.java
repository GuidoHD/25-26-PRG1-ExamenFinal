import java.util.Scanner;

class CalculadoraGeometriaExamen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] historial_f = new String[20];
        double[] historial_a = new double[20];
        double[] historial_p = new double[20];
        int historial_idx = 0;

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while(true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int x = scanner.nextInt();

            if (x == 5) {
                System.out.println("Historial de Calculos");
                double total_area = 0;
                for (int i = 0; i < historial_idx; i++) {
                    System.out.println((i+1) + ". " + historial_f[i] + " -> Area: " + historial_a[i] + ", Perimetro/Volumen: " + historial_p[i]);
                    total_area += historial_a[i];
                }
                System.out.println("Area total acumulada: " + total_area);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double y = 0;
            double z = 0;
            boolean f = false;

            if (x == 1) {
                System.out.print("Radio: ");
                y = scanner.nextDouble();
                if (y > 0) {
                    z = 3.14159 * y * y;
                    double p = 2 * 3.14159 * y;
                    System.out.println("Area: " + z);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(historial_idx < 20) {
                        historial_f[historial_idx] = "Circulo";
                        historial_a[historial_idx] = z;
                        historial_p[historial_idx] = p;
                        historial_idx++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (x == 2) {
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
                    if(historial_idx < 20) {
                        historial_f[historial_idx] = "Rectangulo";
                        historial_a[historial_idx] = a;
                        historial_p[historial_idx] = p;
                        historial_idx++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (x == 3) {
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
                    if(historial_idx < 20) {
                        historial_f[historial_idx] = "Triangulo";
                        historial_a[historial_idx] = a;
                        historial_p[historial_idx] = p;
                        historial_idx++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (x == 4) {
                System.out.print("Radio: ");
                y = scanner.nextDouble();
                System.out.print("Altura: ");
                z = scanner.nextDouble();
                if (y > 0 && z > 0) {
                    double area_base = 3.14159 * y * y;
                    double area_lateral = 2 * 3.14159 * y * z;
                    double area_total = 2 * area_base + area_lateral;
                    double vol = area_base * z;
                    System.out.println("Area Superficial: " + area_total);
                    System.out.println("Volumen: " + vol);
                    f = true;
                    if(historial_idx < 20) {
                        historial_f[historial_idx] = "Cilindro";
                        historial_a[historial_idx] = area_total;
                        historial_p[historial_idx] = vol;
                        historial_idx++;
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
