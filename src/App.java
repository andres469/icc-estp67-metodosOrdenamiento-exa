import controllers.BrandController;
import models.Brand;
import test.TestData;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Examen interciclo de Estructuras de Datos");
        System.out.println("====Configurar studente.env====");

        TestData data = new TestData();
        Brand[] brands = data.createBrands();

        BrandController controller = new BrandController();
        System.out.println("Original");

        for (Brand brand : brands) {
            System.out.println(brand.getBrandName() + " Mas Años vaalidos " + brand.getTotalValidYears());
        }
        controller.sortBubbleDesc(brands);

        System.out.println("Ordenado");

        for (Brand b : brands) {
            System.out.println(b.getBrandName() + " Mas Años vaalidos " + b.getTotalValidYears());
        }

        System.out.println("Buscar marca con 4 años validos");
        Brand found = controller.binarySearchByValidYears(brands, 4, false);
        if (found != null) {
            System.out.println(
                    "Encontrados " + found.getBrandName() + " Total Años Validos " + found.getTotalValidYears());
        } else {
            System.out.println("No encontradas");
        }

        System.out.println(" Buscar con 3 años validos ");
        Brand notFound = controller.binarySearchByValidYears(brands, 3, false);
        if (notFound != null) {
            System.out.println("Encontrados " + notFound.getBrandName());
        } else {
            System.out.println("No encontrados");
        }

    }

}
