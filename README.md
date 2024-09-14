### 1. <#macro>: 再利用可能なコードブロックを定義
<#macro>は、複数のテンプレートで使い回すコードを定義する際に使用します。関数のように、引数を渡すことができ、定義したブロックを他のテンプレートから呼び出せます。

```injectedfreemarker
<#macro greeting name>
    <p>こんにちは、${name}さん！</p>
</#macro>

<!-- マクロの呼び出し -->
<@greeting name="山田"/>
```
```injectedfreemarker
<!-- 複数設定 -->
<#macro layout param1 param2 param3>
    <html>
    <head>
        <title>${param1}</title> <!-- 引数 param1 はタイトル -->
    </head>
    <body>
    <header>
        <h1>${param2}</h1> <!-- 引数 param2 はヘッダーのテキスト -->
    </header>

    <main>
        <p>ここはメインコンテンツです。</p>
        <p>サイドメニュー: ${param3}</p> <!-- 引数 param3 はサイドメニュー内容 -->
            <#nested> <!-- ネストされたコンテンツ（呼び出し元で指定する） -->
    </main>

    <footer>
        <p>フッターの共通部分</p>
    </footer>
    </body>
    </html>
</#macro>

<@layout "My Webpage Title" "Welcome to My Website" "Sidebar Content">
    <h2>ページのメインコンテンツ</h2>
    <p>ここに本文が入ります。</p>
</@layout>

```

### 2. <#include>: 他のテンプレートを読み込む
<#include>は、別のテンプレートをインクルード（読み込み）する際に使用します。レイアウトや共通コンポーネントをテンプレートに追加するのに便利です。

```injectedfreemarker
<!-- メインテンプレート -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <title>サイトタイトル</title>
</head>
<body>
    <#include "header.ftl">
    <main>
        <h1>メインコンテンツ</h1>
    </main>
    <#include "footer.ftl">
</body>
</html>

```

### 3. <#nested>: マクロ内でネストされた内容を挿入する
<#nested>は、マクロ内で外部から渡されたコンテンツを挿入するのに使います。主にマクロを使用してレイアウトを作る際に役立ちます。

```injectedfreemarker
<#macro layout>
    <header>これは共通のヘッダーです</header>
    <main>
        <#nested>
    </main>
    <footer>これは共通のフッターです</footer>
</#macro>

<@layout>
    <h1>ページタイトル</h1>
    <p>これはページのコンテンツです。</p>
</@layout>

```

### 4. <#import>: 外部ファイルからマクロをインポートする
<#import>は、外部テンプレートに定義されたマクロや関数をインポートするために使用します。<#include>と異なり、テンプレート全体ではなく特定のマクロや関数だけを読み込みます。

```injectedfreemarker
<!-- macro.ftl -->
<#macro greeting name>
    <p>こんにちは、${name}さん！</p>
</#macro>

<!-- main.ftl -->
<#import "macro.ftl" as macros>

<@macros.greeting name="田中"/>

```

### 5. <@layout>: カスタムマクロでレイアウトを作成
レイアウト全体をカスタムマクロで定義し、その中でコンテンツを動的に差し込む場合に使われます。<@layout>は、<#nested>と併用して、共通レイアウトを効率的に管理できます。

```injectedfreemarker
<!-- layout.ftl -->
<#macro layout title>
    <html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <header>共通ヘッダー</header>
        <main>
            <#nested>
        </main>
        <footer>共通フッター</footer>
    </body>
    </html>
</#macro>

<!-- main.ftl -->
<#import "layout.ftl" as layout>

<@layout.layout title="ページタイトル">
    <h1>これはメインコンテンツです</h1>
    <p>ページの内容をここに記載します。</p>
</@layout.layout>

```
