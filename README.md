## :leaves: SpringBootでJPA(O/Rマッピング)を使いPostgreSQLとの読み書きサンプル

## 1. 開発環境  
```
統合開発環境：Eclipse 2022-09 R(4.25.0) Pleiades + Spring Tool Suite プラグイン 4.16.1
言語：Java 17  
デベロッパーSDK：Oracle JDK 17.0.5  
フレームワーク：Spring Boot 3.0.0  
-Spring Framework 6.0.2  
-サーブレットエンジン：Apache Tomcat ${tomcatVersion}  
-テンプレートエンジン：Thymeleaf 3.1.0  
-データベース接続：PostgreSQL JDBC 4.2 Driver 42..1  
-O/R マッピング フレームワーク：Hibernate ORM 6.1.5.Final + JPA 2.2  
-ログイン認証:Spring Security 6.0.0
ログイン認証：Form認証(MVC用)、Basic認証(WebAPI用) 兼用
データベース：PostgreSQL 15.1
-データベース管理ツール：pgAdmin 6.16
ビルドツール： Gradle 7.6 Groovy
CSSテンプレート：Bootstrap 5.2.3
```

<br />

### 改良移行中。
※Spring Security 6.0で非推奨となったクラスライブラリのコンフィグ系を推奨クラスに移行。
ログインユーザーをデータベースから検索し比較するメソッドとテスト用のインメモリーにユーザーを持って比較するプログラム追加。
Form認証とBasic認証兼用させMVCのブラウザ向けとWebAPIのデスクトップアプリ、将来のスマホ、タブレットアプリ向けでアクセスできるよう兼用させる。
ビルドツールをMavenからGradle(Groovy)に移行。
O/RマッピングをJava Persistence APIからJakarta Persistence APIに移行
設定ファイルをプロパティファイルからymlファイルに移行。
データベースが変わっても設定ファイルを切り替えるだけで別のデータソースへ切り替わるよう編集。

<br />

## 2. 事前準備  
### サンプルプログラムを実行する際のデータベース作成  
PostgreSQLのクエリーやpgAdminのクエリーツールで以下のSQLを実行するかこれ相当をpgAdminなどの管理ツールのデータベース作成で作成します。  

#### データベース作成(pgAdminでのデフォルト相当)  
データベース名は`SpringBootPostgres`です。  

```
-- Database: SpringBootPostgres

-- DROP DATABASE IF EXISTS "SpringBootPostgres";

CREATE DATABASE "SpringBootPostgres"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Japanese_Japan.932'
    LC_CTYPE = 'Japanese_Japan.932'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
````

#### テーブル作成およびサンプルデータ  
SpringJpaの機能および設定によりテーブルが無ければ作成しますので必要ありません。  
サンプルデータもデータが１件も無ければプログラムにより作成する様になっていますので必要ありません。  


<br />

## 3. [Herokuサービスで確認](https://polarbear-leaning02.herokuapp.com/)
ユーザー名：user、パスワード：pass2user  
※無料版で作成していますのでDynosがスリープから復帰起動するため表示に時間がかかります。   
起動後、30分以内に何も操作しなければ再びスリープに入ります。  
スリープに入り再起動するとアプリも編集データも初期化されます。  
※Herokuの無料版のPostgreSQLは2022/05/29現在バージョンは14です。  

<br />

## 4. 実行イメージ  
#### 画面・イメージ／一覧  
![Img](ReadmeImg.png)  

#### 画面・イメージ／更新  
![Img](ReadmeImg2.png)  

#### 画面・イメージ／例外  
![Img](ReadmeImg3.png)

#### 画面・イメージ／ページなし  
![Img](ReadmeImg4.png)

#### データベース管理ツール・イメージ／テーブル  
![Img](ReadmeImg5.png)  
  