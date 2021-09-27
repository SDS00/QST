<#macro ftselect currencies>
<select name="idFrom">
    <#list currencies as currency>
    <option value=${currency.id}>${currency.name}</option>
    </#list>
</select>
<label>-></label>
<select name="idTo">
    <#list currencies as currency>
    <option value=${currency.id}>${currency.name}</option>
    </#list>
</select>
</#macro>