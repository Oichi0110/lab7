package start;

import handler.CompanyHandler;
import handler.UsersHandler;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
<<<<<<< HEAD
import org.xml.sax.SAXException;
=======
>>>>>>> 1.4.0

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
<<<<<<< HEAD
import javax.xml.transform.TransformerException;
=======
>>>>>>> 1.4.0
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> 1.4.0

public class Main {
    private static File FILE_COMPANY = new File("D:/sitairis/Lab7/src/main/resources/company_dtd.xml").getAbsoluteFile();
    private static File FILE_USERS = new File("D:/sitairis/Lab7/src/main/resources/users_xsd.xml").getAbsoluteFile();
    private static File FILE_XSLT = new File("D:/sitairis/Lab7/src/main/resources/XSLT_template.xslt").getAbsoluteFile();
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser companyParser = factory.newSAXParser();
            CompanyHandler companyHandler = new CompanyHandler();
            companyParser.parse(FILE_COMPANY, companyHandler);
<<<<<<< HEAD
        }catch (SAXException se){
            System.out.println("Sax exception: " + se.getMessage());
        } catch (Exception e){
=======
        }catch(Exception e){
>>>>>>> 1.4.0
            System.out.println(e.getMessage());
        }

        try {
            SAXParser userParser = factory.newSAXParser();
            UsersHandler usersHandler = new UsersHandler();
            userParser.parse(FILE_USERS, usersHandler);
<<<<<<< HEAD
        }catch (SAXException se){
            System.out.println("Sax exception: " + se.getMessage());
        } catch (Exception e){
=======
        }catch (Exception e){
>>>>>>> 1.4.0
            System.out.println(e.getMessage());
        }

        try {
            DocumentBuilderFactory factoryForXpath = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoryForXpath.newDocumentBuilder();
            Document document = builder.parse(FILE_COMPANY);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            XPathExpression expr = xPath.compile("/company/products/product/car_name/text()");
            NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            System.out.println("Название машин: ");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("- " + nodeList.item(i).getNodeValue());
            }

            expr = xPath.compile("//product[price > 1000.00]/car_name/text()");
            nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            System.out.println("\nАвтомобили с ценой выше 1000.00:");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("- " + nodeList.item(i).getNodeValue());
            }

<<<<<<< HEAD
        }catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        } catch (Exception e){
=======
        }catch (Exception e){
>>>>>>> 1.4.0
            System.out.println(e.getMessage());
        }

        try {
            TransformerFactory factoryForXSLT = TransformerFactory.newInstance();
            Transformer transformer = factoryForXSLT.newTransformer(new StreamSource(FILE_XSLT));

            transformer.transform(new StreamSource(FILE_COMPANY), new StreamResult(new File("src/main/resources/output.html")));

            System.out.println("Преобразование завершено! Файл output.html создан.");
<<<<<<< HEAD
        } catch (TransformerException e) {
            System.out.println("Transformer Exception: " + e.getMessage());
=======
>>>>>>> 1.4.0
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}