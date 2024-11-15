# 일정 관리 앱 V.2
 
## [ API 명세서 ]

### 유저 API

* 로그인 후 유저 RD 가능

| 기능    | Method | URL                 | request  | response | 상태코드                                     |
|-------|--------|---------------------|----------|----------|------------------------------------------|
| 유저 등록 | POST   | /users          | 요청 body  | 등록 정보    | 201: 정상 등록        |
| 유저 전체 조회 | GET    | /users      | 요청 param | 조회 정보 | 200: 정상 조회      |
| 유저 선택 조회 | GET    | /users/{id}      | 요청 param | 조회 정보 | 200: 정상 조회  404: 찾을 수 없음    |
| 유저 선택 삭제    | DELETE | /api/users/{id} | 요청 param     | -        | 200: 정상 삭제  404: 찾을 수 없음 |

- `POST` 유저 등록

`URL: /users`

요청
```
{
    "username": "test",
    "password": "1234",
    "email": "test2@test.com"

}
```
응답
```
{
    "id": 1,
    "username": "test",
    "email": "test@test.com",
    "createdAt": "2024-11-15T20:07:00.6628193",
    "modifiedAt": "2024-11-15T20:07:00.6628193"
}
```

- `GET` 유저 전체 조회

URL : /users

요청
```
-
```
응답
```
[
    {
        "id": 1,
        "username": "test",
        "email": "test2@test.com"
    },
    {
        "id": 2,
        "username": "test2",
        "email": "test@test.com"
    }
]
```


- `GET` 유저 선택 조회

`URL: /users/{id}`

요청
```
-
```
응답
```
{
    "id": 1,
    "username": "test",
    "email": "test@test.com"
}
```

- `DELETE` 유저 선택 삭제

URL : users/{id}

요청
```
-
```
응답
```
-
```
### 로그인 API

* 로그인 후 일정 CRUD와 유저 RD 가능

| 기능   | Method | URL         | request  | response   | 상태코드                       |
|------|--------|-------------|----------|------------|----------------------------|
| 로그인  | POST   | /login  | 요청 body  | - | 200: 정상 로그인  404: 찾을 수 없음 |
| 로그아웃 | POST    | /logout | - | -          | 200: 정상 로그아웃 |

- `POST` 로그인

`URL: /login`

요청
```
{
    "email": "test@test.com",
    "password": "1234"
}
```
응답
```
-
```
- `POST` 로그아웃

`URL: /logout`

요청
```
-
```
응답
```
-
```



### 일정 API

* 로그인 후 일정 CRUD 가능

| 기능       | Method | URL                  | request  | response | 상태코드                                             |
|----------|--------|----------------------|----------|----------|--------------------------------------------------|
| 일정 등록    | POST   | /boards      | 요청 body  | 등록 정보    | 201: 정상등록  400: 잘못된 요청                |
| 일정 전체 조회 | GET    | /boards      | 요청 param | 목록 조회 정보 | 200: 정상 조회           |
| 일정 선택 조회    | GET    | /boards/{id} | 요청 param     | 조회 정보    | 200: 정상 조회 404: 찾을 수 없음        |
| 일정 수정    | PUT    | /boards/{id} | 요청 body  | 수정 정보    | 200: 정상 수정    400: 잘못된 요청    404: 찾을 수 없음   |
| 일정 삭제    | DELETE | /boards/{id} | 요청 param     | -        | 200: 정상 삭제  404: 찾을 수 없음 |

- `POST` 일정 등록

`URL: boards`

요청
```
{
    "title": "제목",
    "content": "내용",
    "email": "test@test.com"
}
```

응답
```
{
  "id": 1,
  "title": "제목",
  "content": "내용",
  "username": "test",
  "createdAt": "2024-11-15T18:16:12.8320143",
  "modifiedAt": "2024-11-15T18:16:12.8320143"
}
```

- `GET` 일정 전체 조회

`URL: /boards`

요청
```
-
```
응답
```
"schedulers" :[ {
    "id": 1,
    "userId" : 1,
    "title" : "제목 1"
    "contents" : "할 일 1",
    "createdAt": "2024-11-14T14:53:02.838242",
    "updatedAt": "2024-11-14T14:53:02.838242"
}, {
    "id": 2,
    "userId" : 1,
    "title" : "제목 2"
    "contents" : "할 일 2",
    "createdAt": "2024-11-15T14:53:02.838242",
    "updatedAt": "2024-11-15T14:53:02.838242"
    },
]
```

- `GET` 일정 선택 조회

`URL: /boards/{id}`

요청
```
-
```
응답
```
{
    "id": 1,
    "userId" : 1,
    "title" : "제목 1"
    "contents" : "할 일 1",
    "createdAt": "2024-11-14T14:53:02.838242",
    "updatedAt": "2024-11-14T14:53:02.838242"
}
```
- `PATCH` 일정 수정

`URL: /boards/{id}`

요청
```
{
    "title": "수정된 제목",
    "content": "수정된 내용"
}
```
응답
```
{
    "id": 1,
    "title": "수정된 제목",
    "content": "수정된 내용",
    "username": "test",
    "createdAt": "2024-11-15T19:04:41.852422",
    "modifiedAt": "2024-11-15T19:04:41.852422"
}
```

- `DELETE` 일정 삭제

`URL: /boards/{id}`

요청
```
-
```
응답
```
-
```

## [ ERD ]

<img width="685" alt="image" src="https://github.com/user-attachments/assets/fb288e6d-9e04-4114-8d5b-cb55129e23d7">

