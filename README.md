# Reviews Project

In this project, I have created a website where reviews on various topics are presented to the reader. It has the following components:

**Review Class**

This class has instance variables for an ID, title, description, an image URL, review category, review text as content, as well as the date review is written. Constructor, getters and setters are also provided.

**Review Repository**

This class creates Review instances and populates a map to store the reviews. It has findOneReview() and findAll() methods to facilitate the process.

**Review Controller**

This has a findAllReviews() method which is mapped to a URL. This method then puts all the reviews into a model forwarding to a "reviews" template. A findOneReview() method is mapped to a URL which uses an id as key to put one of the reviews into the model, thereby forwarding to a "review" template. 

**Reviews and Review HTMLPages**

These two pages are HTML/Thymeleaf templates that display information from the Review instances found in the Review Repository.