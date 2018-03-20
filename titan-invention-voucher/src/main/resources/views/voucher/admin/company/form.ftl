<#assign content>
<div class="vou-conpageft">
    <div class="vou-details">
        <div class="vou-deta-infor vou-custo-form">
            <form id="Js_form"  method="post"  class="form-inline" action="/voucher/admin/company/${id}">
                <ul>
                    <li class="vou-custo-firstli form-group">
                        <span>服务券号：</span>
                        <input name="voucherno" class="form-control" type="text">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('admin/company/bindVoucher')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">