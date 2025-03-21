# Hanteo_Test
한터 글로벌 과제 테스트 코드입니다

# 게시판 트리 자료구조 구현

## 설계 및 구현 내용

### 사용한 자료구조

#### 트리(Tree)
- 카테고리와 게시판 간의 계층 구조를 표현하기 위해
- 트리는 특정 카테고리를 기준으로 하위 카테고리 및 게시판을 한 번에 탐색하고,
계층형 데이터를 JSON 형태로 직렬화하는 데 적합하기 때문

### 주요 클래스 설명

#### Category
- 카테고리 엔티티
- 하위 카테고리(`subCategories`)와 게시판(`boards`) 리스트를 포함
- `addSubCategory()`, `addBoard()` 메서드를 통해 하위 항목 추가 지원

#### Board
- 게시판 엔티티
- ID, 이름을 가짐
- 공지사항, 익명게시판 등의 실체가 Board로 생성됨

#### BoardManager
- **게시판 관리 클래스**
- 일반 게시판을 자동으로 ID 증가하며 생성
- **익명게시판은 싱글턴 패턴으로 최초 호출 시 1회만 생성**
- 공지사항 전용 `createNoticeBoard()` 메서드도 제공

#### CategoryTree
- 카테고리 및 게시판을 트리로 관리
- 카테고리 등록, 관계 연결, 게시판 추가
- 카테고리 검색 (id, name)
- JSON 변환 기능 제공

#### App (샘플 실행)
- 실제 트리 구조를 구성하고 JSON으로 출력하는 샘플 코드 작성

#### 출력 결과 확인
<img src="https://github.com/user-attachments/assets/3685269f-1426-4861-9ba8-4bb99e5c02a5" width="400"/>

---

### 요구사항 구현
- **카테고리 트리 구조 구현**
- **카테고리 ID, 이름으로 검색 가능** (Optional로 반환)
- **JSON 직렬화 가능 (Jackson 사용)**
- **익명게시판 싱글턴 패턴으로 구현 (여러 카테고리에 공유)**
- **공지사항은 카테고리마다 별도의 Board로 생성**

---

### 테스트 코드
- `CategoryTree`의 카테고리/게시판 추가 및 트리 관계 테스트
- `BoardManager`의 ID 자동 증가 및 익명게시판 싱글턴 테스트
- JSON 출력 정상 여부 테스트
- 없는 카테고리 검색 실패 케이스 테스트

### 테스트 결과 확인
<img width="360" alt="image" src="https://github.com/user-attachments/assets/8d01e9d4-ca78-4d55-ba5f-02095b48f8fb" />

---

### 사용 기술
- Java 17
- JUnit5
- Jackson
