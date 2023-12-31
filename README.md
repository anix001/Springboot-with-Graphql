﻿# Springboot-with-Graphql
## API 

```python
-GET BookByID
- http://localhost:[port]/graphql

-request:
query{
    bookById(bookId:2) {
        id,
        title,
        author,
        pages
    }
}

-response:
{
    "data": {
        "bookById": {
            "id": "2",
            "title": "title updated",
            "author": "anix001",
            "pages": 300
        }
    }
}
```

```python
-GET Books
- http://localhost:[port]/graphql

-request:
query{
    books {
        id,
        title,
        author,
        pages
    }
}

-response:
{
    "data": {
        "books": [
            {
                "id": "2",
                "title": "title updated",
                "author": "anix001",
                "pages": 300
            }
        ]
    }
}
```

```python
-POST Book
- http://localhost:[port]/graphql

-request:
mutation{
    storeBookToDb(book:{
        title:"Life.",
        description:"About Life",
        author:"anix001",
        price:2700,
        pages:300
    }){
        id,
        title
    }
}

response:
{
    "data": {
        "storeBookToDb": {
            "id": "4",
            "title": "Life."
        }
    }
}
```

```python
-update  Book
- http://localhost:[port]/graphql

-request:
mutation{
    updateBookToDb(bookId:2, book:{
        title:"title updated now"
    }){
        id,
        title
    }
}

-response:
{
    "data": {
        "updateBookToDb": {
            "id": "2",
            "title": "title updated now"
        }
    }
}
```

```python
-DELETE Book
- http://localhost:[port]/graphql

-request:
mutation{
    deleteBook(bookId:3)
}

-response:
{
    "data": {
        "deleteBook": true
    }
}
```




