import java.util.Scanner;

class CalculadoraGeometriaExamen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] historialFigura = new String[20];
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
                    System.out.println((i+1) + ". " + historialFigura[i] + " -> Area: " + historialArea[i] + ", Perimetro/Volumen: " + historialPerimetro[i]);
                    totalArea += historialArea[i];
                }
                System.out.println("Area total acumulada: " + totalArea);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            boolean figuraPosible = false;

            if (botonPresionado == 1) {
                System.out.print("Radio: ");
                double radioCirculo = scanner.nextDouble();
                if (radioCirculo > 0) {
                    double areaCirculo = 3.14159 * radioCirculo * radioCirculo;
                    double perimetroCirculo = 2 * 3.14159 * radioCirculo;
                    System.out.println("Area: " + areaCirculo);
                    System.out.println("Perimetro: " + perimetroCirculo);
                    figuraPosible = true;
                    if(historialIndice < 20) {
                        historialFigura[historialIndice] = "Circulo";
                        historialArea[historialIndice] = areaCirculo;
                        historialPerimetro[historialIndice] = perimetroCirculo;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (botonPresionado == 2) {
                System.out.print("Base: ");
                double baseRectangulo = scanner.nextDouble();
                System.out.print("Altura: ");
                double alturaRectangulo = scanner.nextDouble();
                if (baseRectangulo > 0 && alturaRectangulo > 0) {
                    double areaRectangulo = baseRectangulo * alturaRectangulo;
                    double perimetroRectangulo = 2 * (baseRectangulo + alturaRectangulo);
                    System.out.println("Area: " + areaRectangulo);
                    System.out.println("Perimetro: " + perimetroRectangulo);
                    figuraPosible = true;
                    if(historialIndice < 20) {
                        historialFigura[historialIndice] = "Rectangulo";
                        historialArea[historialIndice] = areaRectangulo;
                        historialPerimetro[historialIndice] = perimetroRectangulo;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (botonPresionado == 3) {
                System.out.print("Lado 1: ");
                double lado1 = scanner.nextDouble();
                System.out.print("Lado 2: ");
                double lado2 = scanner.nextDouble();
                System.out.print("Lado 3: ");
                double lado3 = scanner.nextDouble();
                if (lado1 > 0 && lado2 > 0 && lado3 > 0 && (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1)) {
                    double semiperimetroTriangulo = (lado1 + lado2 + lado3) / 2;
                    double areaTriangulo = Math.sqrt(semiperimetroTriangulo * (semiperimetroTriangulo - lado1) * (semiperimetroTriangulo - lado2) * (semiperimetroTriangulo - lado3));
                    double perimetroTriangulo = lado1 + lado2 + lado3;
                    System.out.println("Area: " + areaTriangulo);
                    System.out.println("Perimetro: " + perimetroTriangulo);
                    figuraPosible = true;
                    if(historialIndice < 20) {
                        historialFigura[historialIndice] = "Triangulo";
                        historialArea[historialIndice] = areaTriangulo;
                        historialPerimetro[historialIndice] = perimetroTriangulo;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (botonPresionado == 4) {
                System.out.print("Radio: ");
                double radioCilindro = scanner.nextDouble();
                System.out.print("Altura: ");
                double alturaCilindro = scanner.nextDouble();
                if (radioCilindro > 0 && alturaCilindro > 0) {
                    double areaBaseCilindro = 3.14159 * radioCilindro * radioCilindro;
                    double areaLateralCilindro = 2 * 3.14159 * radioCilindro * alturaCilindro;
                    double areaTotalCilindro = 2 * areaBaseCilindro + areaLateralCilindro;
                    double volumenCilindro = areaBaseCilindro * alturaCilindro;
                    System.out.println("Area Superficial: " + areaTotalCilindro);
                    System.out.println("Volumen: " + volumenCilindro);
                    figuraPosible = true;
                    if(historialIndice < 20) {
                        historialFigura[historialIndice] = "Cilindro";
                        historialArea[historialIndice] = areaTotalCilindro;
                        historialPerimetro[historialIndice] = volumenCilindro;
                        historialIndice++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }

            if (figuraPosible) {
                System.out.println("Calculo completado.");
            }
        }
        scanner.close();
    }
}
