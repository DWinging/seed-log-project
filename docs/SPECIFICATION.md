# 📑 Project Specification: Seed-Log

> **"기술적 숙련도 향상을 넘어, 소통의 장으로 진화하는 확장형 커뮤니티 플랫폼"**

## 1. 개요 (Overview)
* **프로젝트 정의:** 개인 기술 아카이빙을 위한 블로그 구축 및 대규모 커뮤니티로의 단계적 확장 프로젝트.
* **선택 이유 (Why Blog?):** * **접근성:** 일상적으로 자주 접하는 서비스로서 도메인 이해도가 높아 기능 구현에 집중 가능.
    * **기술적 훈련:** 서버 통신, 복합적인 CRUD, 데이터 흐름 제어 등 백엔드 핵심 역량의 종합적인 연습 가능.
    * **확장 가능성:** 1인 블로그에서 다중 사용자 커뮤니티로 진화하며 발생하는 트래픽 처리 및 API 고도화 과정을 단계적으로 학습하기에 최적의 모델임.
* **핵심 가치:** * **Fundamental:** 서블릿 기반 Spring MVC 구조의 명확한 이해.
    * **Efficiency:** Java 21과 가상 스레드를 활용한 자원 최적화.
    * **Reliability:** 데이터 정규화와 트랜잭션 관리를 통한 서비스 안정성 확보.

## 2. 기술 스택 (Tech Stack)
* **Language/Framework:** Java 21, Spring Boot 4.0.3, Spring Data JPA
* **Database:** MySQL 8.0 (Indexing 및 정규화 최적화)
* **Frontend:** Vue.js 3 (Vite, Composition API)
* **Tools:** STS (Backend), VS Code (Frontend), Git/GitHub

## 3. 단계별 로드맵 (Roadmap)

### 🚩 1단계: 블로그 기본 기능 (단기 목표)
> **"내 손으로 직접 통제하는 데이터 저장소와 전시 공간"**
* **Post:** 마크다운 기반 CRUD, 페이징 조회, 조회수 카운팅.
* **Taxonomy:** 카테고리(1:N) 및 다중 태그(N:M) 시스템 구축.
* **Search:** 제목/내용 키워드 기반 검색 기능.
* **Admin:** 작성자 전용 관리자 페이지 (기초 인증 적용).

### 🚩 2단계: 소통 기능 확장 (중기 목표)
> **"단방향 정보 전달에서 양방향 소통으로"**
* **Auth:** Spring Security + JWT 기반 회원가입 및 로그인 관리.
* **Comment:** 댓글/대댓글 기능 (Recursive 구조) 및 트래픽 증가에 따른 성능 고려.
* **User Management:** 개인정보 관리 및 프로필 페이지 구축.

### 🚩 3단계: 커뮤니티 진화 (최종 목표)
> **"장르를 한정 짓지 않는 사용자 중심의 교류의 장"**
* **Engagement:** '좋아요' 기반 인기 게시글 추천 시스템 및 공지사항 기능.
* **Network:** 사용자 간 팔로우 기능 및 관심 글 즐겨찾기(Scrap).
* **Optimization:** 대규모 접속에 대비한 캐싱 전략 및 Java 21 가상 스레드 최적화.

## 4. 기술적 도전 및 고려 사항 (Technical Challenges)
* **서블릿 및 내부 구조 이해:** Spring MVC의 `DispatcherServlet` 동작 원리와 서블릿 필터(Filter) 수준의 데이터 흐름을 명확히 파악하여 과거 구현 실패 원인(기초 개념 부족)을 극복함.
* **Extensibility:** 1단계 설계 시점부터 3단계 커뮤니티 확장을 고려한 DB 스키마 정규화 수행.
* **Concurrency:** 댓글 및 좋아요 급증 시 데이터 정합성과 동시성 제어(Concurrency Control) 학습.

## 5. 페르소나 및 타깃 전략 (Future Plan)
* **현 단계:** 개발 환경 구축 및 기본 기능 완성에 집중 (기술 숙련도 위주).
* **확장 단계:** 기능 완성 후, 실제 소통의 장으로 활용하기 위해 기존 블로그 서비스(Velog, Tistory 등)와의 차별점을 분석하여 페르소나 설정 및 UI/UX 고도화 예정.
