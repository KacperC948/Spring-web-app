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
        Author kacper = new Author("Kacper", "Cichosz");
        Book ksiazkaKacpra = new Book("Jakas książka", "1234444");
        Publisher publisher1 = new Publisher("Kosinskiego", "Wrzesnia", "Polska", "62-300");
        kacper.getBooks().add(ksiazkaKacpra);
        ksiazkaKacpra.getAuthors().add(kacper);

        authorRepository.save(kacper);
        bookRepository.save(ksiazkaKacpra);
        publisherRepository.save(publisher1);

        Author martyna = new Author("Martyna", "Kluk");
        Book ksiazkaMartyny = new Book("Jakas ksiazka Martyny", "123123");
        martyna.getBooks().add(ksiazkaMartyny);
        ksiazkaMartyny.getAuthors().add(martyna);

        authorRepository.save(martyna);
        bookRepository.save(ksiazkaMartyny);

        System.out.println("Started in BootStrapdata class");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
