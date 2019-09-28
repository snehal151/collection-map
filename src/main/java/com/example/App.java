
package com.example;

        import com.example.model.Product;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.util.*;


public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Map<Integer, Product> map = new HashMap<>();
        int choice;
        Scanner s = new Scanner(System.in);
        do {
            logger.info("1. Insert");
            logger.info("2. Display one");

            logger.info("3. Display all");
            logger.info("4. Delete");

            logger.info("5. Update");

            logger.info("6. Exit");
            logger.info("Enter your choice: ");

            choice = s.nextInt();
            Product p;
            switch (choice) {
                case 1: // INSERT
                    logger.info("Enter product info: ");
                    logger.info("Id: ");
                    int tId = s.nextInt();
                    logger.info("Name: ");
                    String tName = s.next();
                    logger.info("Company: ");
                    String tCompany = s.next();
                    logger.info("Price: ");
                    float tPrice = s.nextFloat();

                    p = new Product(tId, tName, tCompany, tPrice);

                    map.put(p.getId(), p);

                    break;
                case 2:
                    logger.info("Enter product id to display: ");
                    int idToSearch = s.nextInt();
                    Product pp = map.get(idToSearch);
                    if (pp == null) {
                        logger.info("Value not found!");
                    } else {
                        logger.info("PRODUCT: " + pp);
                    }

                    break;
                case 3:
                    for (Map.Entry<Integer, Product> e : map.entrySet()) {
                        logger.info(e.getKey() + "," + e.getValue());

                    }
                    break;
                case 4:// Delete one Record
                    logger.info("Enter Product id : ");
                    idToSearch = s.nextInt();
                    map.remove(idToSearch);
                    break;

                case 5://Update Record
                    logger.info("Enter Product id : ");
                    int idToReplace = s.nextInt();
                    Product p3 = map.get(idToReplace);
                    if (p3 == null) {
                        logger.info("Value not found!");
                    } else {
                        logger.info("Name: ");
                        String rName = s.next();
                        logger.info("Company: ");
                        String rCompany = s.next();
                        logger.info("Price: ");
                        float rPrice = s.nextFloat();

                        Product rp = new Product(idToReplace, rName, rCompany, rPrice);

                        map.replace(rp.getId(), rp);

                    }

                    break;

                default:
                    logger.info("Please enter correct choice: ");
                    break;
            }

        } while (choice != 6);
    }

}
