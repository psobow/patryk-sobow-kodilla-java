package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        Library library = new Library("Biblioteka 1");

        Book book1 = new Book("Interesting book", "Johny", LocalDate.of(2000, 10, 15));
        Book book2 = new Book("Boring book", "Jerry", LocalDate.of(1999, 5, 25));
        library.add(book1);
        library.add(book2);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow Copy Biblioteka 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Copy Biblioteka 3");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        //When
        clonedLibrary.remove(book2);

        //Then
        Assert.assertEquals(1, library.getObjects().size());
        Assert.assertEquals(2, deepClonedLibrary.getObjects().size());

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
    }
}
