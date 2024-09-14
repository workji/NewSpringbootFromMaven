<#macro page title>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${title}</title>
            <link rel="stylesheet" href="/css/main.css">
        </head>
        <body>
            <header>
                <#include "header.ftlh">
            </header>

            <div class="container">
                <nav class="left-menu">
                    <#include "left-menu.ftlh">
                </nav>

                <main>
                    <#nested>
                </main>
            </div>

            <footer>
                <#include "footer.ftlh">
            </footer>

            <script src="/js/main.js"></script>
        </body>
    </html>
</#macro>