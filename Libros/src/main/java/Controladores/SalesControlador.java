/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Autor: 100655341 Reynaldo
 * Descripción:
 * Esta clase representa la clase de los controladores de la aplicación.
 * Desde aqui se manejan los datos que digitara el usuario para darle respuesta a sus necesidades.
 * La conexión a la base de datos se gestiona mediante la clase CConexion.
 */

package Controladores;

import Dao.SalesDao;
import Dao.StoreDao;
import Modelos.Sales;
import Modelos.Store;
import Modelos.Authors;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;
import Dao.AuthorsDao;
import Dao.PublishersDao;
import Dao.TitleDao;
import Modelos.Publishers;
import Modelos.Title;
import java.util.List;
import java.util.Scanner;
import Dao.sales_logDao;
import Modelos.sales_log;



/**
 *
 * @author rodri
 */
public class SalesControlador {
    /*
    *100655341 Reynaldo Rodriguez Polanco
    *Este metodo se encarga de recolectar los datos usados en la clase Sales para las ventas
    *Proporciona métodos para insertar, actualizar, eliminar y recuperar registros de la tabla de ventas.
    * Utiliza la clase SalesDao para interactuar con la base de datos.
    * La entrada y salida de datos se gestionan mediante la clase Scanner.
    */
    public void Proceso1(){
        Scanner sc = new Scanner(System.in);
        SalesDao sd = new SalesDao();
        Sales sales = new Sales();
        List<Sales> l = new LinkedList<Sales>();
        int option = Integer.MAX_VALUE;
        String fechaT = "";
        String fechap = "";
        
        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige una opcion: "
                    + "\n 1-insertar nuevo libro en venta"
                    + "\n 2-Actualizar libro en venta"
                    + "\n 3-Eliminar libro en venta"
                    + "\n 4-Mostrar un libro en venta "
                    + "\n 5-Listar libro en venta"
                    + "\n 0-Salir del sistema");
            
            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("----------INSERTAR NUEVO LIBRO----------");
                    System.out.println("----------------------------------------");
                    System.out.println("ESCRIBA EL CODIGO DEL LIBRO");
                    sales.setstor_id(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL NUMERO DE ORDEN");
                    sales.setord_num(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA LA FECHA DE SALIDA PARA VENTA EN FORMATO \"dd/MM/yyyy\"");
                    fechaT = "";
                    while (fechaT.equals("")) {
                        try {
                            MaskFormatter formato = new MaskFormatter("##/##/####");
                            String texto = sc.next();
                            fechap = (String) formato.stringToValue(texto.trim());
                            fechaT = fechap;
                        } catch (Exception e) {
                            System.out.println("POR FAVOR INGRESE LA FECHA CON FORMATO dd/MM/yyyy ");
                            System.out.println("Ingrese la Fecha");
                        }
                    }
                    sales.setord_date(fechaT);                    
                    System.out.println("ESCRIBA LA CANTIDAD DE LIBROS");
                    sales.setqty(Integer.MAX_VALUE);
                    while (sales.getqty() == Integer.MAX_VALUE) {
                        try {
                            sales.setqty(sc.nextInt());
                        } catch (Exception e) {
                            System.out.println("escriba un numero valido");
                            sc.nextLine();
                        }
                        if (Integer.compare(sales.getqty(), 0) < 0) {
                            sales.setqty(Integer.MAX_VALUE);
                            System.out.println("El precion puede ser 0 pero nunca menor que 0");
                        }
                    }
                    System.out.println("ESCRIBA LA CONDICION DE PAGO");
                    sales.setpayterms(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL TITULO");
                    sales.settitle_id(sc.next());
                    sc.nextLine();
                    sd.insert(sales);
                    System.out.println("----------------------------------------");
                    break;
                    case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("------------ACTUALIZAR LIBRO------------");
                    System.out.println("----------------------------------------");
                    sales = new Sales();
                    l = sd.selectAll();
                    System.out.println("ID Libro" + "\t" + "Orden numerico" + "\t" + "Fecha" + "\t" + "Cantidad" + "\t" + "Terminos de pago" + "\t" + "Titulo");
                    for (Sales sales1 : l) {
                        System.out.println(sales1.getstor_id() + "\t" + sales1.getord_num() + "\t" + sales1.getord_dateString() + "\t" + sales1.getqty() + "\t" + sales1.getpayterms() + "\t" + sales1.gettitle_id());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL LIBRO PARA ACTUALIZAR");
                    sales.setstor_id(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL ORDEN NUMERICO DEL LIBRO");
                    sales.setord_num(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA LA FECHA DE SALIDA DEL LIBRO EN FORMATO \"dd/MM/yyyy\"");
                    fechaT = "";
                    while (fechaT.equals("")) {
                        try {
                            MaskFormatter formato = new MaskFormatter("##/##/####");
                            String texto = sc.next();
                            fechap = (String) formato.stringToValue(texto.trim());
                            fechaT = fechap;
                        } catch (Exception e) {
                            System.out.println("POR FAVOR INGRESE LA FECHA CON FORMATO dd/MM/yyyy ");
                            System.out.println("Ingrese la Fecha");
                        }
                    }
                    sales.setord_date(fechaT);
                    sc.nextLine();
                    System.out.println("ESCRIBA LA CANTIDAD DE LIBROS");
                    sales.setqty(Integer.MAX_VALUE);
                    while (sales.getqty()== Integer.MAX_VALUE) {
                        try {
                            option = sc.nextInt();
                            sales.setqty(option);
                        } catch (Exception e) {
                            System.out.println("Digite un numero valido");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    System.out.println("ESCRIBA LOS TERMINOS DE PAGO");
                    sales.setpayterms(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL TITULO");
                    sales.settitle_id(sc.next());
                    sc.nextLine();
    
                    sd.update(sales);
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("-------------ELIMINAR LIBRO-------------");
                    System.out.println("----------------------------------------");
                     l = sd.selectAll();
                    System.out.println("ID Libro" + "\t" + "Orden numerico" + "\t" + "Fecha" + "\t" + "Cantidad" + "\t" + "Terminos de pago" + "\t" + "Titulo");
                    for (Sales sales1 : l) {
                        System.out.println(sales1.getstor_id() + "\t" + sales1.getord_num() + "\t" + sales1.getord_dateString() + "\t" + sales1.getqty() + "\t" + sales1.getpayterms() + "\t" + sales1.gettitle_id());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL CURSO A ELIMINAR");
                    sd.delete(sc.nextLine());
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("--------------MIRAR UN LIBRO------------");
                    System.out.println("----------------------------------------");
                    l = sd.selectAll();
                    System.out.println("ID DEL LIBRO" + "\t" + "ORDEN NUMERICO");
                    for (Sales sales1 : l) {
                        System.out.println(sales1.getstor_id() + "\t" + sales1.getord_num());
                    }
                    System.out.println("ESCRIBA EL ID DEL LLIbro A VER");
                    sales = sd.oneSales(sc.nextLine());
                    System.out.println(sales.getstor_id() + "\t" + sales.getord_num() + "\t" + sales.getord_dateString() + "\t" + sales.getqty() + "\t" + sales.getpayterms() + "\t" + sales.gettitle_id());
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("----------------------------------------");
                    System.out.println("------------TODOS LOS LIBROS------------");
                    System.out.println("----------------------------------------");
                    l = sd.selectAll();
                    System.out.println("ID Libro" + "\t" + "Orden numerico" + "\t" + "Fecha" + "\t" + "Cantidad" + "\t" + "Terminos de pago" + "\t" + "Titulo");
                    for (Sales sales1 : l) {
                        System.out.println(sales1.getstor_id() + "\t" + sales1.getord_num() + "\t" + sales1.getord_dateString() + "\t" + sales1.getqty() + "\t" + sales1.getpayterms() + "\t" + sales1.gettitle_id());
                    }
                    System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");
    }
    
        /*
    *100655341 Reynaldo Rodriguez Polanco
    *Proporciona métodos para insertar, actualizar, eliminar y recuperar registros de la tabla.
    * Utiliza la clase Store para interactuar con la base de datos.
    * La entrada y salida de datos se gestionan mediante la clase Scanner.
    */
    public static void Proceso2(){
        Scanner sc = new Scanner(System.in);
        StoreDao sd = new StoreDao();
        Store store = new Store();
        List<Store> l = new LinkedList<Store>();
        int option = Integer.MAX_VALUE;
        String fechaT = "";
        String fechap = "";
        
        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige una opcion: "
                    + "\n 1-insertar nueva tienda"
                    + "\n 2-Actualizar tienda"
                    + "\n 3-Eliminar tienda"
                    + "\n 4-Mostrar una tienda"
                    + "\n 5-Listar tiendas"
                    + "\n 0-Salir del sistema");
            
            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("----------INSERTAR NUEVO LIBRO----------");
                    System.out.println("----------------------------------------");
                    System.out.println("ESCRIBA EL CODIGO DE LA TIENDA");
                    store.setstor_id(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL NOMBRE DE LA TIENDA");
                    store.setstor_name(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA DIRECCION");
                    store.setstor_address(sc.next());  
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA CIUDAD");
                    store.setcity(sc.next());
                 
                    System.out.println("ESCRIBE EL ESTADO AL QUE PERTENECE");
                    store.setstate(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL CODIGO POSTAL");
                    store.setzip(sc.next());
                    sc.nextLine();
                    
                    sd.insert(store);
                    System.out.println("----------------------------------------");
                    break;
                    case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("------------ACTUALIZAR TIENDA------------");
                    System.out.println("----------------------------------------");
                    store = new Store();
                    l = sd.selectAll();
                    System.out.println("ID tienda" + "\t" + "Nombre tienda" + "\t" + "Direccion tienda" + "\t" + "Ciudad tienda" + "\t" + "Estado tienda" + "\t" + "Codigo postal");
                    for (Store store1 : l) {
                        System.out.println(store1.getstor_id() + "\t" + store1.getstor_name()+ "\t" + store1.getstor_address()+ "\t" + store1.getcity()+ "\t" + store1.getstate()+ "\t" + store1.getzip());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DE LA TIENDA PARA ACTUALIZAR");
                    store.setstor_id(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL NOMBRE DE LA TIENDA");
                    store.setstor_name(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA DIRECCION");
                    store.setstor_address(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA CIUDAD");
                    store.setcity(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBE EL ESTADO AL QUE PERTENECE");
                    store.setstate(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL CODIGO POSTAL");
                    store.setzip(sc.next());
                    sc.nextLine();
    
                    sd.update(store);
                    System.out.println("----------------------------------------");
                    break;
                    
                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("-------------ELIMINAR TIENDA-------------");
                    System.out.println("----------------------------------------");
                    l = sd.selectAll();
                    System.out.println("ID tienda" + "\t" + "Nombre tienda" + "\t" + "Direccion tienda" + "\t" + "Ciudad tienda" + "\t" + "Estado tienda" + "\t" + "Codigo postal");
                    for (Store store1 : l) {
                        System.out.println(store1.getstor_id() + "\t" + store1.getstor_name()+ "\t" + store1.getstor_address()+ "\t" + store1.getcity()+ "\t" + store1.getstate()+ "\t" + store1.getzip());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DE LA TIENDA A ELIMINAR");
                    sc.nextLine(); // Consumir el carácter de nueva línea
                    String idToDelete = sc.nextLine();
                    sd.delete(idToDelete);
                    System.out.println("----------------------------------------");
                    break;
                    
                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("--------------MIRAR UNA TIENDA------------");
                    System.out.println("----------------------------------------");
                    l = sd.selectAll();
                    System.out.println("ID DE LA TIENDA" + "\t" + "NOMBRE DE LA TIENDA");
                    for (Store store1 : l) {
                        System.out.println(store1.getstor_id() + "\t" + store1.getstor_name());
                    }
                    System.out.println("ESCRIBA EL ID DEL LIBRO A VER");
                    String storeId = sc.nextLine();
                    store = sd.oneStore(storeId);
                    if (store != null) {
                        System.out.println(store.getstor_id() + "\t" + store.getstor_name() + "\t" + store.getstor_address() + "\t" + store.getcity() + "\t" + store.getstate() + "\t" + store.getzip());
                    } else {
                        System.out.println("No se encontro la tienda con ID: " + storeId);
                    }

                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("----------------------------------------");
                    System.out.println("------------TODOS LAS TIENDAS------------");
                    System.out.println("----------------------------------------");
                    l = sd.selectAll();
                    System.out.println("ID tienda" + "\t" + "Nombre tienda" + "\t" + "Direccion tienda" + "\t" + "Ciudad tienda" + "\t" + "Estado tienda" + "\t" + "Codigo postal");
                    for (Store store1 : l) {
                        System.out.println(store1.getstor_id() + "\t" + store1.getstor_name()+ "\t" + store1.getstor_address()+ "\t" + store1.getcity()+ "\t" + store1.getstate()+ "\t" + store1.getzip());
                    }
                    System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");
        
        
    }
    /*
    *100655341 Reynaldo Rodriguez Polanco
    * Mismo proceso
    */
    public void Proceso3(){

        Scanner sc = new Scanner(System.in);
        AuthorsDao authorsDao = new AuthorsDao();
        Authors author = new Authors();
        List<Authors> authorsList = new LinkedList<>();
        int option = Integer.MAX_VALUE;
        
        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige una opcion: "
                    + "\n 1 - Insertar nuevo autor"
                    + "\n 2 - Actualizar autor"
                    + "\n 3 - Eliminar autor"
                    + "\n 4 - Mostrar un autor"
                    + "\n 5 - Listar autores"
                    + "\n 0 - Salir del sistema");
            
            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un número valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("--------- INSERTAR NUEVO AUTOR ---------");
                    System.out.println("----------------------------------------");
                    System.out.println("ESCRIBA EL ID DEL AUTOR");
                    author.setAu_id(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL APELLIDO DEL AUTOR");
                    author.setAu_lname(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL NOMBRE DEL AUTOR");
                    author.setAu_fname(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL NUMERO DE TELEFONO");
                    author.setPhone(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA DIRECCION");
                    author.setAddress(sc.next());  
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA LA CIUDAD");
                    author.setCity(sc.next());
                 
                    System.out.println("ESCRIBA EL ESTADO");
                    author.setState(sc.next());
                    sc.nextLine();
                    
                    System.out.println("ESCRIBA EL CODIGO POSTAL");
                    author.setZip(sc.next());
                    sc.nextLine();
                    
                    System.out.println("¿CONTRATO? (true/false)");
                    author.setContract(sc.nextBoolean());
                    sc.nextLine();
                    
                    authorsDao.insert(author);
                    System.out.println("----------------------------------------");
                    break;

                    case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("-------- ACTUALIZAR INFORMACION ---------");
                    System.out.println("----------------------------------------");
                    author = new Authors();
                    authorsList = authorsDao.selectAll();
                    System.out.println("ID Autor" + "\t" + "Nombre" + "\t" + "Apellido" + "\t" + "Telefono" + "\t" + "Direccion" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "Codigo Postal" + "\t" + "Contrato");
                    for (Authors author1 : authorsList) {
                        System.out.println(author1.getAu_id() + "\t" + author1.getAu_fname() + "\t" + author1.getAu_lname() + "\t" + author1.getPhone() + "\t" + author1.getAddress() + "\t" + author1.getCity() + "\t" + author1.getState() + "\t" + author1.getZip() + "\t" + author1.isContract());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL AUTOR PARA ACTUALIZAR");
                    String authorIdToUpdate = sc.next();
                    sc.nextLine();

                    author = authorsDao.oneAuthor(authorIdToUpdate);
                    if (author != null) {
                        System.out.println("ESCRIBA EL NUEVO NOMBRE");
                        author.setAu_fname(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO APELLIDO");
                        author.setAu_lname(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO TELEFONO");
                        author.setPhone(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA LA NUEVA DIRECCION");
                        author.setAddress(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA LA NUEVA CIUDAD");
                        author.setCity(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO ESTADO");
                        author.setState(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO CODIGO POSTAL");
                        author.setZip(sc.next());
                        sc.nextLine();

                        System.out.println("¿NUEVO CONTRATO? (true/false)");
                        author.setContract(sc.nextBoolean());
                        sc.nextLine();

                        if (authorsDao.update(author)) {
                            System.out.println("Autor actualizado exitosamente.");
                        } else {
                            System.out.println("No se pudo actualizar el autor.");
                        }
                    } else {
                        System.out.println("No se encontro ningun autor con el ID proporcionado.");
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 3:
                 
                    System.out.println("----------------------------------------");
                    System.out.println("------------ ELIMINAR AUTOR ------------");
                    System.out.println("----------------------------------------");
                    authorsList = authorsDao.selectAll();
                    System.out.println("ID Autor" + "\t" + "Nombre" + "\t" + "Apellido" + "\t" + "Telefono" + "\t" + "Direccion" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "Codigo Postal" + "\t" + "Contrato");
                    for (Authors author1 : authorsList) {
                        System.out.println(author1.getAu_id() + "\t" + author1.getAu_fname() + "\t" + author1.getAu_lname() + "\t" + author1.getPhone() + "\t" + author1.getAddress() + "\t" + author1.getCity() + "\t" + author1.getState() + "\t" + author1.getZip() + "\t" + author1.isContract());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL AUTOR A ELIMINAR");
                    sc.nextLine(); // Consumir el carácter de nueva línea
                    String authorIdToDelete = sc.nextLine();

                    if (authorsDao.delete(authorIdToDelete)) {
                        System.out.println("Autor eliminado exitosamente.");
                    } else {
                        System.out.println("No se pudo eliminar el autor.");
                    }
                    System.out.println("----------------------------------------");
                    break;

              
                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("-------------- VER DETALLES DE UN AUTOR ------------");
                    System.out.println("----------------------------------------");
                    authorsList = authorsDao.selectAll();
                    System.out.println("ID Autor" + "\t" + "Nombre" + "\t" + "Apellido" + "\t" + "Telefono" + "\t" + "Direccion" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "Codigo Postal" + "\t" + "Contrato");
                    for (Authors author1 : authorsList) {
                        System.out.println(author1.getAu_id() + "\t" + author1.getAu_fname() + "\t" + author1.getAu_lname() + "\t" + author1.getPhone() + "\t" + author1.getAddress() + "\t" + author1.getCity() + "\t" + author1.getState() + "\t" + author1.getZip() + "\t" + author1.isContract());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL AUTOR A VER");
                    String authorIdToView = sc.nextLine();
                    Authors authorToView = authorsDao.oneAuthor(authorIdToView);
                    if (authorToView != null) {
                        System.out.println("Detalles del autor:");
                        System.out.println("ID Autor: " + authorToView.getAu_id());
                        System.out.println("Nombre: " + authorToView.getAu_fname());
                        System.out.println("Apellido: " + authorToView.getAu_lname());
                        System.out.println("Telefono: " + authorToView.getPhone());
                        System.out.println("Direccion: " + authorToView.getAddress());
                        System.out.println("Ciudad: " + authorToView.getCity());
                        System.out.println("Estado: " + authorToView.getState());
                        System.out.println("Codigo Postal: " + authorToView.getZip());
                        System.out.println("Contrato: " + authorToView.isContract());
                    } else {
                        System.out.println("No se encontro ningun autor con el ID: " + authorIdToView);
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 5:
                     System.out.println("----------------------------------------");
                        System.out.println("------------ TODOS LOS AUTORES ------------");
                        System.out.println("----------------------------------------");
                        authorsList = authorsDao.selectAll();
                        System.out.println("ID Autor" + "\t" + "Nombre" + "\t" + "Apellido" + "\t" + "Telefono" + "\t" + "Direccion" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "Codigo Postal" + "\t" + "Contrato");
                        for (Authors author1 : authorsList) {
                            System.out.println(author1.getAu_id() + "\t" + author1.getAu_fname() + "\t" + author1.getAu_lname() + "\t" + author1.getPhone() + "\t" + author1.getAddress() + "\t" + author1.getCity() + "\t" + author1.getState() + "\t" + author1.getZip() + "\t" + author1.isContract());
                        }
                        System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");
    }
    
   

     /*
    *100655341 Reynaldo Rodriguez Polanco
    * Mismo proceso
    */

    public void Proceso4() {

        Scanner sc = new Scanner(System.in);
        PublishersDao publishersDao = new PublishersDao();
        Publishers publisher = new Publishers();
        List<Publishers> publishersList = new LinkedList<>();
        int option = Integer.MAX_VALUE;

        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige una opcion: "
                    + "\n 1 - Insertar nuevo editor"
                    + "\n 2 - Actualizar editor"
                    + "\n 3 - Eliminar editor"
                    + "\n 4 - Mostrar un editor"
                    + "\n 5 - Listar editores"
                    + "\n 0 - Salir del sistema");

            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un número válido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("--------- INSERTAR NUEVO EDITOR ---------");
                    System.out.println("----------------------------------------");
                    System.out.println("ESCRIBA EL ID DEL EDITOR");
                    publisher.setPub_id(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL NOMBRE DEL EDITOR");
                    publisher.setPub_name(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA LA CIUDAD");
                    publisher.setCity(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL ESTADO");
                    publisher.setState(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL PAÍS");
                    publisher.setCountry(sc.next());
                    sc.nextLine();

                    publishersDao.insert(publisher);
                    System.out.println("----------------------------------------");
                    break;

                case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("-------- ACTUALIZAR INFORMACIÓN ---------");
                    System.out.println("----------------------------------------");
                    publisher = new Publishers();
                    publishersList = publishersDao.selectAll();
                    System.out.println("ID Editor" + "\t" + "Nombre" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "País");
                    for (Publishers publisher1 : publishersList) {
                        System.out.println(publisher1.getPub_id() + "\t" + publisher1.getPub_name() + "\t" + publisher1.getCity() + "\t" + publisher1.getState() + "\t" + publisher1.getCountry());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL EDITOR PARA ACTUALIZAR");
                    String publisherIdToUpdate = sc.next();
                    sc.nextLine();

                    publisher = publishersDao.onePublisher(publisherIdToUpdate);
                    if (publisher != null) {
                        System.out.println("ESCRIBA EL NUEVO NOMBRE");
                        publisher.setPub_name(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA LA NUEVA CIUDAD");
                        publisher.setCity(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO ESTADO");
                        publisher.setState(sc.next());
                        sc.nextLine();

                        System.out.println("ESCRIBA EL NUEVO PAÍS");
                        publisher.setCountry(sc.next());
                        sc.nextLine();

                        if (publishersDao.update(publisher)) {
                            System.out.println("Editor actualizado exitosamente.");
                        } else {
                            System.out.println("No se pudo actualizar el editor.");
                        }
                    } else {
                        System.out.println("No se encontró ningún editor con el ID proporcionado.");
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("------------ ELIMINAR EDITOR ------------");
                    System.out.println("----------------------------------------");
                    publishersList = publishersDao.selectAll();
                    System.out.println("ID Editor" + "\t" + "Nombre" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "País");
                    for (Publishers publisher1 : publishersList) {
                        System.out.println(publisher1.getPub_id() + "\t" + publisher1.getPub_name() + "\t" + publisher1.getCity() + "\t" + publisher1.getState() + "\t" + publisher1.getCountry());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL EDITOR A ELIMINAR");
                    sc.nextLine(); // Consumir el carácter de nueva línea
                    String publisherIdToDelete = sc.nextLine();

                    if (publishersDao.delete(publisherIdToDelete)) {
                        System.out.println("Editor eliminado exitosamente.");
                    } else {
                        System.out.println("No se pudo eliminar el editor.");
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("-------------- VER DETALLES DE UN EDITOR ------------");
                    System.out.println("----------------------------------------");
                    publishersList = publishersDao.selectAll();
                    System.out.println("ID Editor" + "\t" + "Nombre" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "País");
                    for (Publishers publisher1 : publishersList) {
                        System.out.println(publisher1.getPub_id() + "\t" + publisher1.getPub_name() + "\t" + publisher1.getCity() + "\t" + publisher1.getState() + "\t" + publisher1.getCountry());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL EDITOR A VER");
                    String publisherIdToView = sc.nextLine();
                    Publishers publisherToView = publishersDao.onePublisher(publisherIdToView);
                    if (publisherToView != null) {
                        System.out.println("Detalles del editor:");
                        System.out.println("ID Editor: " + publisherToView.getPub_id());
                        System.out.println("Nombre: " + publisherToView.getPub_name());
                        System.out.println("Ciudad: " + publisherToView.getCity());
                        System.out.println("Estado: " + publisherToView.getState());
                        System.out.println("País: " + publisherToView.getCountry());
                    } else {
                        System.out.println("No se encontro ningún editor con el ID: " + publisherIdToView);
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 5:
                    System.out.println("----------------------------------------");
                    System.out.println("------------ TODOS LOS EDITORES ------------");
                    System.out.println("----------------------------------------");
                    publishersList = publishersDao.selectAll();
                    System.out.println("ID Editor" + "\t" + "Nombre" + "\t" + "Ciudad" + "\t" + "Estado" + "\t" + "País");
                    for (Publishers publisher1 : publishersList) {
                        System.out.println(publisher1.getPub_id() + "\t" + publisher1.getPub_name() + "\t" + publisher1.getCity() + "\t" + publisher1.getState() + "\t" + publisher1.getCountry());
                    }
                    System.out.println("----------------------------------------");
                    break;

                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");
    }
    
     /*
    *100655341 Reynaldo Rodriguez Polanco
    * Mismo proceso
    */
    
    public void Proceso5() {
    Scanner sc = new Scanner(System.in);
    TitleDao titleDao = new TitleDao();
    Title title = new Title();
    List<Title> titlesList = new LinkedList<>();
    int option = Integer.MAX_VALUE;

    System.out.println("========================================");
    while (option != 0) {
        System.out.println("Elige una opcion: "
                + "\n 1 - Insertar nuevo título"
                + "\n 2 - Actualizar título"
                + "\n 3 - Eliminar título"
                + "\n 4 - Mostrar un título"
                + "\n 5 - Listar títulos"
                + "\n 0 - Salir del sistema");

        do {
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Digite un número válido");
                sc.nextLine();
            }
        } while (option == Integer.MAX_VALUE);

        switch (option) {
            case 0:
                System.out.println("----------------------------------------");
                System.out.println("-----------------SALIENDO---------------");
                System.out.println("----------------------------------------");
                break;
            case 1:
                System.out.println("----------------------------------------");
                System.out.println("--------- INSERTAR NUEVO TÍTULO ---------");
                System.out.println("----------------------------------------");
                System.out.println("ESCRIBA EL ID DEL TÍTULO");
                title.setTitle_id(sc.next());
                sc.nextLine();

                System.out.println("ESCRIBA EL TÍTULO");
                title.setTitle(sc.next());
                sc.nextLine();

                System.out.println("ESCRIBA EL TIPO");
                title.setType(sc.next());
                sc.nextLine();

                System.out.println("ESCRIBA EL ID DEL EDITOR");
                title.setPub_id(sc.next());
                sc.nextLine();

                System.out.println("ESCRIBA EL PRECIO");
                title.setPrice(sc.nextBigDecimal());
                sc.nextLine();

                System.out.println("ESCRIBA EL AVANCE");
                title.setAdvance(sc.nextBigDecimal());
                sc.nextLine();

                System.out.println("ESCRIBA LA REGALÍA");
                title.setRoyalty(sc.nextInt());
                sc.nextLine();

                System.out.println("ESCRIBA LAS VENTAS DEL AÑO HASTA LA FECHA");
                title.setYtd_sales(sc.nextInt());
                sc.nextLine();

                System.out.println("ESCRIBA LAS NOTAS");
                title.setNotes(sc.nextLine());

                System.out.println("ESCRIBA LA FECHA DE PUBLICACIÓN (AAAA-MM-DD)");
                title.setPubdate(java.sql.Date.valueOf(sc.nextLine()));

                titleDao.insert(title);
                System.out.println("----------------------------------------");
                break;

            case 2:
                System.out.println("----------------------------------------");
                System.out.println("-------- ACTUALIZAR INFORMACIÓN ---------");
                System.out.println("----------------------------------------");
                title = new Title();
                titlesList = titleDao.selectAll();
                System.out.println("ID Título" + "\t" + "Título" + "\t" + "Tipo" + "\t" + "ID Editor" + "\t" + "Precio" + "\t" + "Avance" + "\t" + "Regalía" + "\t" + "Ventas Año Hasta la Fecha" + "\t" + "Notas" + "\t" + "Fecha de Publicación");
                for (Title title1 : titlesList) {
                    System.out.println(title1.getTitle_id() + "\t" + title1.getTitle() + "\t" + title1.getType() + "\t" + title1.getPub_id() + "\t" + title1.getPrice() + "\t" + title1.getAdvance() + "\t" + title1.getRoyalty() + "\t" + title1.getYtd_sales() + "\t" + title1.getNotes() + "\t" + title1.getPubdate());
                }
                System.out.println("****************************************");
                System.out.println("ESCRIBA EL ID DEL TÍTULO PARA ACTUALIZAR");
                String titleIdToUpdate = sc.next();
                sc.nextLine();

                title = titleDao.oneTitle(titleIdToUpdate);
                if (title != null) {
                    System.out.println("ESCRIBA EL NUEVO TÍTULO");
                    title.setTitle(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL NUEVO TIPO");
                    title.setType(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL NUEVO ID DEL EDITOR");
                    title.setPub_id(sc.next());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL NUEVO PRECIO");
                    title.setPrice(sc.nextBigDecimal());
                    sc.nextLine();

                    System.out.println("ESCRIBA EL NUEVO AVANCE");
                    title.setAdvance(sc.nextBigDecimal());
                    sc.nextLine();

                    System.out.println("ESCRIBA LA NUEVA REGALÍA");
                    title.setRoyalty(sc.nextInt());
                    sc.nextLine();

                    System.out.println("ESCRIBA LAS NUEVAS VENTAS DEL AÑO HASTA LA FECHA");
                    title.setYtd_sales(sc.nextInt());
                    sc.nextLine();

                    System.out.println("ESCRIBA LAS NUEVAS NOTAS");
                    title.setNotes(sc.nextLine());

                    System.out.println("ESCRIBA LA NUEVA FECHA DE PUBLICACIÓN (AAAA-MM-DD)");
                    title.setPubdate(java.sql.Date.valueOf(sc.nextLine()));

                    if (titleDao.update(title)) {
                        System.out.println("Título actualizado exitosamente.");
                    } else {
                        System.out.println("No se pudo actualizar el título.");
                    }
                } else {
                    System.out.println("No se encontró ningún título con el ID proporcionado.");
                }
                System.out.println("----------------------------------------");
                break;

            case 3:
                System.out.println("----------------------------------------");
                System.out.println("------------ ELIMINAR TÍTULO ------------");
                System.out.println("----------------------------------------");
                titlesList = titleDao.selectAll();
                System.out.println("ID Título" + "\t" + "Título" + "\t" + "Tipo" + "\t" + "ID Editor" + "\t" + "Precio" + "\t" + "Avance" + "\t" + "Regalía" + "\t" + "Ventas Año Hasta la Fecha" + "\t" + "Notas" + "\t" + "Fecha de Publicación");
                for (Title title1 : titlesList) {
                    System.out.println(title1.getTitle_id() + "\t" + title1.getTitle() + "\t" + title1.getType() + "\t" + title1.getPub_id() + "\t" + title1.getPrice() + "\t" + title1.getAdvance() + "\t" + title1.getRoyalty() + "\t" + title1.getYtd_sales() + "\t" + title1.getNotes() + "\t" + title1.getPubdate());
                }
                System.out.println("****************************************");
                System.out.println("ESCRIBA EL ID DEL TÍTULO A ELIMINAR");
                sc.nextLine(); // Consumir el carácter de nueva línea
                String titleIdToDelete = sc.nextLine();

                if (titleDao.delete(titleIdToDelete)) {
                    System.out.println("Título eliminado exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar el título.");
                }
                System.out.println("----------------------------------------");
                break;

            case 4:
                System.out.println("----------------------------------------");
                System.out.println("-------------- VER DETALLES DE UN TÍTULO ------------");
                System.out.println("----------------------------------------");
                titlesList = titleDao.selectAll();
                System.out.println("ID Título" + "\t" + "Título" + "\t" + "Tipo" + "\t" + "ID Editor" + "\t" + "Precio" + "\t" + "Avance" + "\t" + "Regalía" + "\t" + "Ventas Año Hasta la Fecha" + "\t" + "Notas" + "\t" + "Fecha de Publicación");
                for (Title title1 : titlesList) {
                    System.out.println(title1.getTitle_id() + "\t" + title1.getTitle() + "\t" + title1.getType() + "\t" + title1.getPub_id() + "\t" + title1.getPrice() + "\t" + title1.getAdvance() + "\t" + title1.getRoyalty() + "\t" + title1.getYtd_sales() + "\t" + title1.getNotes() + "\t" + title1.getPubdate());
                }
                System.out.println("****************************************");
                System.out.println("ESCRIBA EL ID DEL TÍTULO A VER");
                String titleIdToView = sc.nextLine();
                Title titleToView = titleDao.oneTitle(titleIdToView);
                if (titleToView != null) {
                    System.out.println("Detalles del título:");
                    System.out.println("ID Título: " + titleToView.getTitle_id());
                    System.out.println("Título: " + titleToView.getTitle());
                    System.out.println("Tipo: " + titleToView.getType());
                    System.out.println("ID Editor: " + titleToView.getPub_id());
                    System.out.println("Precio: " + titleToView.getPrice());
                    System.out.println("Avance: " + titleToView.getAdvance());
                    System.out.println("Regalía: " + titleToView.getRoyalty());
                    System.out.println("Ventas Año Hasta la Fecha: " + titleToView.getYtd_sales());
                    System.out.println("Notas: " + titleToView.getNotes());
                    System.out.println("Fecha de Publicación: " + titleToView.getPubdate());
                } else {
                    System.out.println("No se encontró ningún título con el ID: " + titleIdToView);
                }
                System.out.println("----------------------------------------");
                break;

            case 5:
                System.out.println("----------------------------------------");
                System.out.println("------------ TODOS LOS TÍTULOS ------------");
                System.out.println("----------------------------------------");
                titlesList = titleDao.selectAll();
                System.out.println("ID Título" + "\t" + "Titulo" + "\t" + "Tipo" + "\t" + "ID Editor" + "\t" + "Precio" + "\t" + "Avance" + "\t" + "Regalía" + "\t" + "Ventas Año Hasta la Fecha" + "\t" + "Notas" + "\t" + "Fecha de Publicación");
                for (Title title1 : titlesList) {
                    System.out.println(title1.getTitle_id() + "\t" + title1.getTitle() + "\t" + title1.getType() + "\t" + title1.getPub_id() + "\t" + title1.getPrice() + "\t" + title1.getAdvance() + "\t" + title1.getRoyalty() + "\t" + title1.getYtd_sales() + "\t" + title1.getNotes() + "\t" + title1.getPubdate());
                }
                System.out.println("----------------------------------------");
                break;

            default:
                System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                break;
        }
    }
    System.out.println("========================================");
}
    
     /*
    *100655341 Reynaldo Rodriguez Polanco
    * Mismo proceso
    */
    
    public void Proceso6() {
     


        Scanner sc = new Scanner(System.in);
        sales_logDao sd = new sales_logDao();
        sales_log salesLog = new sales_log();
        List<sales_log> l;
        int option = Integer.MAX_VALUE;
        
        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige una opcion: "
                    + "\n 1- Insertar nueva venta"
                    + "\n 2- Actualizar venta"
                    + "\n 3- Eliminar venta"
                    + "\n 4- Mostrar una venta"
                    + "\n 5- Listar ventas"
                    + "\n 0- Salir del sistema");
            
            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("------INSERTAR NUEVA VENTA------");
                    System.out.println("----------------------------------------");

                    System.out.println("Ingrese el ID de la tienda:");
                    String storId = sc.next();
                    System.out.println("Ingrese el número de orden:");
                    String ordNum = sc.next();

                    sales_log newSale = new sales_log();
                    newSale.setStorId(storId);
                    newSale.setOrdNum(ordNum);

                    if (sd.insert(newSale)) {
                        System.out.println("Venta insertada exitosamente.");
                    } else {
                        System.out.println("No se pudo insertar la venta.");
                    }
                    break;
                case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("------ACTUALIZAR VENTA------");
                    System.out.println("----------------------------------------");

                    System.out.println("Ingrese el ID de la venta que desea actualizar:");
                    int salesLogIdToUpdate = sc.nextInt();

                    sales_log saleToUpdate = sd.oneSalesLog(salesLogIdToUpdate);

                    if (saleToUpdate != null) {

                        System.out.println("Ingrese el nuevo ID de la tienda:");
                        String newStorId = sc.next();
                        saleToUpdate.setStorId(newStorId);
                        if (sd.update(saleToUpdate)) {
                            System.out.println("Venta actualizada exitosamente.");
                        } else {
                            System.out.println("No se pudo actualizar la venta.");
                        }
                    } else {
                        System.out.println("No se encontro ninguna venta con el ID proporcionado.");
                    }
                    break;
                case 3:
                 System.out.println("----------------------------------------");
                System.out.println("------ELIMINAR VENTA------");
                System.out.println("----------------------------------------");

                System.out.println("Ingrese el ID de la venta que desea eliminar:");
                int salesLogIdToDelete = sc.nextInt();

                sales_log saleToDelete = sd.oneSalesLog(salesLogIdToDelete);
                if (saleToDelete != null) {

                    System.out.println("¿Esta seguro de que desea eliminar la venta? (S/N)");
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("S")) {

                        if (sd.delete(salesLogIdToDelete)) {
                            System.out.println("Venta eliminada exitosamente.");
                        } else {
                            System.out.println("No se pudo eliminar la venta.");
                        }
                    } else {
                        System.out.println("Operacion de eliminación cancelada.");
                    }
                } else {
                    System.out.println("No se encontro ninguna venta con el ID proporcionado.");
                }
                    break;
                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("------MOSTRAR UNA VENTA------");
                    System.out.println("----------------------------------------");

                    System.out.println("Ingrese el ID de la venta que desea ver:");
                    int salesLogIdToShow = sc.nextInt();

                    sales_log saleToShow = sd.oneSalesLog(salesLogIdToShow);

                    if (saleToShow != null) {

                        System.out.println("Detalles de la venta con ID " + salesLogIdToShow + ":");
                        System.out.println("ID de la tienda: " + saleToShow.getStorId());
                        System.out.println("Número de orden: " + saleToShow.getOrdNum());

                    } else {
                        System.out.println("No se encontro ninguna venta con el ID proporcionado.");
                    }
                    break;
                case 5:
                     System.out.println("----------------------------------------");
                    System.out.println("------LISTAR TODAS LAS VENTAS------");
                    System.out.println("----------------------------------------");


                    List<sales_log> salesLogs = sd.selectAll();


                    if (!salesLogs.isEmpty()) {

                        System.out.println("ID | ID de Tienda | Número de Orden | ID de Título | ID de Autor | Fecha de Registro | Precio | Cantidad");

                        for (sales_log sale : salesLogs) {
                            System.out.println(sale.getSalesLogId() + " | " + sale.getStorId() + " | " + sale.getOrdNum() + " | " + sale.getTitleId() + " | " + sale.getAuId() + " | " + sale.getLogFecha() + " | " + sale.getPrice() + " | " + sale.getQuantity());
                        }
                    } else {
                        System.out.println("No hay ventas registradas en la base de datos.");
                    }
                    break;
                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");

    }
}





        
    
