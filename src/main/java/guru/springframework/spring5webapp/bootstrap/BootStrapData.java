package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Dzieki implementacji interfejsu CommandLineRunner mozemy tworzyc obiekty w kodzie wykorzystujac metodę
//run z interfejsu CommandLineRunner
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Kosinskiego", "Wrzesnia", "Polska", "62-300");
        publisher1.setName("Dupa blada");
        publisherRepository.save(publisher1);

        Author kacper = new Author("Kacper", "Cichosz");
        Book ksiazkaKacpra = new Book("Jakas książka", "1234444");
        kacper.getBooks().add(ksiazkaKacpra);
        ksiazkaKacpra.getAuthors().add(kacper);
        ksiazkaKacpra.setPublisher(publisher1);

        authorRepository.save(kacper);
        bookRepository.save(ksiazkaKacpra);
        publisherRepository.save(publisher1);

        Author martyna = new Author("Martyna", "Kluk");
        Book ksiazkaMartyny = new Book("Jakas ksiazka Martyny", "123123");
        martyna.getBooks().add(ksiazkaMartyny);
        ksiazkaMartyny.getAuthors().add(martyna);
        ksiazkaMartyny.setPublisher(publisher1);

        authorRepository.save(martyna);
        bookRepository.save(ksiazkaMartyny);
        publisherRepository.save(publisher1);

        System.out.println("Started in BootStrapdata class");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }

//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//    private final PublisherRepository publisherRepository;
//
//    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//        this.publisherRepository = publisherRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.println("Started in Bootstrap");
//
//        Publisher publisher = new Publisher();
//        publisher.setName("SFG Publishing");
//        publisher.setCity("St Petersburg");
//        publisher.setState("FL");
//
//        publisherRepository.save(publisher);
//
//        System.out.println("Publisher Count: " + publisherRepository.count());
//
//        Author eric = new Author("Eric", "Evans");
//        Book ddd = new Book("Domain Driven Design", "123123");
//        eric.getBooks().add(ddd);
//        ddd.getAuthors().add(eric);
//
//        ddd.setPublisher(publisher);
//        publisher.getBooks().add(ddd);
//
//        authorRepository.save(eric);
//        bookRepository.save(ddd);
//        publisherRepository.save(publisher);
//
//        Author rod = new Author("Rod", "Johnson");
//        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
//        rod.getBooks().add(noEJB);
//        noEJB.getAuthors().add(rod);
//
//        noEJB.setPublisher(publisher);
//        publisher.getBooks().add(noEJB);
//
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
//        publisherRepository.save(publisher);
//
//        System.out.println("Number of Books: " + bookRepository.count());
//        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
//    }
}
