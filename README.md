## MovieFlix 
Movieflix Web Application has been designed to stream HD movies online and it has been developed more user friendly with wide options and features. To consume movieflix services user has to sign up for movieflix which acctivates your entertainment pack. 

## Features of Application:

1. User can search movies by Title, Type, Genre, and Year
2. Filter Titles by ImdbVotes/ImdbRatings
3. Comment and view titles given by other users
4. Rate and view ratings given by other users

## project directory structure:

**`client`** [*module-complete*]: contains ui app (HTML, CSS, JS, fonts, images)   
**`layout`** [*module-layout*]: contains layout related files (CSS, HTML).     
**`server`** [*module-api*]: contains REST API

## URI to REST API


1. URI to List all Titles 
	**`http://localhost:9093/movieflix/api/titles`**

2. URI to UPDATE a Title 
   **`http://localhost:9093/movieflix/api/titles`**
   
3. URI to create a Title
	**`http://localhost:9093/movieflix/api/titles`**
	
4. URI to delete a Title
   **`http://localhost:9093/movieflix/api/titles/{mid}`**
   
5. URI to get Titles by year 
   **`http://localhost:9093/movieflix/api/titles/year/{year}`**	

6. URI to get Titles by type
   **`http://localhost:9093/movieflix/api/titles/type/{type}`**		

7. URI to get Titles by genre
   **`http://localhost:9093/movieflix/api/titles/genre/{genre}`** 

8. URI to get Titles by Title    
   **`http://localhost:9093/movieflix/api/titles/title/{title}`**

9. URI to get Titles by Id
   **`http://localhost:9093/movieflix/api/titles/{id}`**   

10. URI to filter by IMDB Votes
   **`http://localhost:9093/movieflix/api/titles/imdbvotes`**

11. URI to filter by IMDB Rating
    **`http://localhost:9093/movieflix/api/titles/imdbrating`**

12. URI to Rate a Title
    **`http://localhost:9093/movieflix/api//ratings/user/{uid}/title/{mid}`**	
	
13. URI to Comment a Title
    **`http://localhost:9093/movieflix/api/comments/user/{uid}/title/{mid}`**

14. URI to Signup an User
    **`http://localhost:9093/movieflix/api/users`**

15. URI to Update an User
    **`http://localhost:9093/movieflix/api/users/{id}`**

16. URI to Delete an User
    **`http://localhost:9093/movieflix/api/users/{id}`**

## ADMIN OPERATIONS	

17. URI to add new Title
    **`http://localhost:9093/movieflix/api/admin/titles`**
	
18. URI to Edit existing Title	
    **`http://localhost:9093/movieflix/api/admin/titles/{id}`**

19. URI to Delete Title 
    **`http://localhost:9093/movieflix/api/admin/titles/{id}`**