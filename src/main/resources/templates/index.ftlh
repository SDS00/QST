<#import "base.ftlh" as base>
<#import "currency_from_to.ftlh" as ftselect>

<@base.page>
    <form id="get-exchange-rate">
        <@ftselect.ftselect currencies/>
        <input type="submit" value="Получить">
    </form>

    <table>
        <thead>
            <tr>
                <th>Из</th>
                <th>В</th>
                <th>Значение</th>
                <th>Дата</th>
            </tr>
        </thead>
        <tbody id="exchange-rates">

        </tbody>
    </table>

    <form id="add-currency">
        <label for="name">Название валюты</label>
        <input name="name" type="text">
        <input type="submit" value="Добавить">
    </form>

    <form id="add-exchange-rate">
        <@ftselect.ftselect currencies/>
        <label for="value">Значение</label>
        <input name="value" type="text">
        <input type="submit" value="Добавить">
    </form>

    <script src="/index_page.js"></script>
</@base.page>