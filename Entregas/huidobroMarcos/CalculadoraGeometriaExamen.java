import java.util.Scanner;

class CalculadoraGeometriaExamen {

    static String[] historialFigura = new String[20];
    static double[] historialArea = new double[20];
    static double[] historialResultado = new double[20];
    static int historialIndice = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while (true) {
            mostrarMenu();

            int botonPresionado = scanner.nextInt();

            if (botonPresionado == 1) {
                calcularCirculo(scanner);
            } else if (botonPresionado == 2) {
                calcularRectangulo(scanner);
            } else if (botonPresionado == 3) {
                calcularTriangulo(scanner);
            } else if (botonPresionado == 4) {
                calcularCilindro(scanner);
            } else if (botonPresionado == 5) {
                mostrarHistorial();
                break;
            } else {
                System.out.println("Opción no valida");
            }

        }
        scanner.close();
    }


    static void mostrarMenu(){
        System.out.println("[1] Circulo");
        System.out.println("[2] Rectangulo");
        System.out.println("[3] Triangulo");
        System.out.println("[4] Cilindro");
        System.out.println("[5] Ver historial y Salir");
        System.out.print("Seleccione figura: ");
    }



    static void calcularCirculo(Scanner scanner){
        System.out.print("Radio: ");
        double radio = scanner.nextDouble();

        if (radio > 0) {
            double area = Math.PI * radio * radio;
            double perimetro = 2 * Math.PI * radio;

            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);

            guardarHistorial("Circulo", area, perimetro);
        } else {
            System.out.println("Radio invalido");
        }
    }


    static void calcularRectangulo(Scanner scanner) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        if (base > 0 && altura > 0) {
            double area = base * altura;
            double perimetro = 2 * (base + altura);

            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);

            guardarHistorial("Rectangulo", area, perimetro);
        } else {
            System.out.println("Dimensiones invalidas");
        }
    }



    static void calcularTriangulo(Scanner scanner) {
        System.out.print("Lado 1: ");
        double lado1 = scanner.nextDouble();
        System.out.print("Lado 2: ");
        double lado2 = scanner.nextDouble();
        System.out.print("Lado 3: ");
        double lado3 = scanner.nextDouble();

        if (lado1 > 0 && lado2 > 0 && lado3 > 0 &&
                lado1 + lado2 > lado3 &&
                lado1 + lado3 > lado2 &&
                lado2 + lado3 > lado1) {

            double s = (lado1 + lado2 + lado3) / 2;
            double area = Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
            double perimetro = lado1 + lado2 + lado3;

            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);

            guardarHistorial("Triangulo", area, perimetro);
        } else {
            System.out.println("Lados invalidos");
        }
    }




    static void calcularCilindro(Scanner scanner) {
        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        if (radio > 0 && altura > 0) {
            double areaBase = Math.PI * radio * radio;
            double areaLateral = 2 * Math.PI * radio * altura;
            double areaTotal = 2 * areaBase + areaLateral;
            double volumen = areaBase * altura;

            System.out.println("Area Superficial: " + areaTotal);
            System.out.println("Volumen: " + volumen);

            guardarHistorial("Cilindro", areaTotal, volumen);
        } else {
            System.out.println("Dimensiones invalidas");
        }
    }

    static void guardarHistorial(String figura, double area, double resultado) {
        if (historialIndice < 20) {
            historialFigura[historialIndice] = figura;
            historialArea[historialIndice] = area;
            historialResultado[historialIndice] = resultado;
            historialIndice++;
        }
        System.out.println("Calculo completado.");
    }
    static void mostrarHistorial() {
        System.out.println("Historial de Calculos");
        double totalArea = 0;

        for (int i = 0; i < historialIndice; i++) {
            System.out.println((i + 1) + ". " + historialFigura[i] +
                            " -> Area: " + historialArea[i] +
                            ", Resultado: " + historialResultado[i]
            );
            totalArea += historialArea[i];
        }

        System.out.println("Area total acumulada: " + totalArea);
        System.out.println("Gracias por usar la calculadora.");
    }













}


