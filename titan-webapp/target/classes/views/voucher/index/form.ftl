<#assign content>
<form id="Js_form" >
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" name="email" placeholder="Email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Check me out
        </label>
    </div>
</form>
</#assign>

<#assign script>
    <script>
        seajs.use('index/form.js')
    </script>
</#assign>

<#include "/voucher/layout/singleLayout.ftl">
