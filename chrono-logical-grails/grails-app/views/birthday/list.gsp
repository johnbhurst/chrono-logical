

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Birthday List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Birthday</g:link></span>
        </div>
        <div class="body">
            <h1>Birthday List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="birthDate" title="Birth Date" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${birthdayInstanceList}" status="i" var="birthdayInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${birthdayInstance.id}">${fieldValue(bean:birthdayInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:birthdayInstance, field:'birthDate')}</td>
                        
                            <td>${fieldValue(bean:birthdayInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${birthdayInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
