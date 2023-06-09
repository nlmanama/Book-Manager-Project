# Book Manager Project

### Proposal

This application is a book managing service. It should allow the user to add a book into their library of books. 
Including details such as: 
- author
- date read
- rating
- self-created tags

The application should then allow the user to sort through their library of books 
to find books by metrics such as the author, the date they read the book, or which tags they want to include in the 
search. The application would have a way to retain all books that have previously been entered by the user. It would 
also have a user interface that give the user the option to add books or search for books.

The ideal user for this application would be an avid reader who is in need of tracking their reads. This project is 
of interest to me because as someone who reads a lot, I have grown frustrated with the current book managing 
applications that already exists. Goodreads for one does not allow users to tag books or search for books in their 
library by tags. It has limited searching function that only allows you to sort through your all books by several 
metrics, but does not allow you to filter through your library and only show the books you want. Other alternatives 
such as StoryGraph has other issues such as the interface being difficult to navigate, and still not having all the 
filtering functionalities that I would find useful in managing my library. Hence, an application that allows the 
storing and sorting of books in an easy way would be the ideal project to create.

### User stories
- As a user, I want to be able to add a book to my library
- As a user, I want to be able to add attributes (such as author, ratings...) to my books
- As a user, I want to be able to create unique tags and assign them to books
- As a user, I want to be able to remove a book from my library
- As a user, I want to be able to search for books by their attributes
- As a user, I want to be able to search books by filtering my library with which tags I want to include 
- As a user, I want to have the option to save my library to a file
- As a user, I want to have the option to load my library from a file

#### Credit
Classes, methods, and tests relating to data persistence, specifically working with the JSON library is based off of 
the example JsonSerializationDemo project in CPSC 210 at UBC.<br/>
The use of JTable was based off the example here: https://www.geeksforgeeks.org/java-swing-jtable/ <br/>
The visual component (showing a JPG) was based off the example here: https://www.codespeedy.com/how-to-add-an-image-in-jframe/ <br/>
The use of the WindowListener interface was based off the documentation here: https://docs.oracle.com/javase/tutorial/uiswing/events/windowlistener.html