define(function (require) {
    require("datepicker")

		require('formvalidation')
		require('formvalidation.bootstrap')


    //时间插件
    $(".date-picker").bootstrapDP({
        language: "zh-CN",
        autoclose: true,
        format: "yyyy-mm-dd"
    });

    var voucherList  = {
			"2015": {
				"用友网络南京分公司": [
					"畅捷通好会计财务软件+进销存管理软件",
					"畅捷通小微企业管理软件+云服务（3户）",
					"畅捷通小微企业管理软件+云服务（5户）"
				],
				"南京天心科技软件有限公司": [
					"天元小微企业管理软件（3户）",
					"天成ERP管理软件（8户）"
				],
				"南京踏浪软件开发有限公司": [
					"CAXA图纸设计软件（3户）",
					"CAXA实体设计软件（1户）",
					"CAXA工艺设计软件（2户）",
					"CAXA图纸管理软件（2户）"
				],
				"江苏叁拾叁信息技术有限公司": [
					"叁拾叁管理协同软件（30用户）",
					"叁拾叁管理协同软件（50用户）"
				],
				"南京丹书科技有限公司": [
					"致远协同办公应用软件（30用户）",
					"致远移动商务软件（200人/50G/500条短信）"
				],
				"徐州徐工信息技术服务股份有限公司": [
					"MES制造系统",
					"EMS能源管理系统",
					"智慧工厂的规划和实施",
					"设备管理系统"
				],
				"南京新模式软件集成有限公司": [
					"电子文档加密软件（20个客户端）",
					"电子文档管理软件（10个用户数）",
					"打印安全管理软件（5个打印端）"
				],
				"江苏鸿信系统集成有限公司": [
					"400云呼叫中心+网络传真+外勤助手（20用户）+视频会议"
				],
				"江苏佰腾科技有限公司": [
					"佰腾专利巴巴电商平台+定制版专利管家+专利费用代缴服务"
				]
			},
			"2016": {
				"用友网络南京分公司": [
					"T+管理软件+协同移动OA工作圈",
					"中小企业云服务+互联网财务管理A套餐",
					"中小企业云服务+互联网财务管理B套餐"
				],
				"江苏巨成软件科技有限公司": [
					"天心小微版ERP管理软件",
					"巨成ERP管理软件"
				],
				"南京丹书科技有限公司": [
					"协同办公应用软件"
				],
				"南京东进诚软件有限公司": [
					"简单报销系统",
					"云OA系统",
					"云合同系统"
				],
				"江苏叁拾叁信息技术有限公司": [
					"叁拾叁协同管理系统",
					"天心ERP标准版"
				],
				"南京敏行软件有限公司": [
					"企业ERP管理系统（SAP公司B1产品）"
				],
				"南京苏豪科技实业有限公司": [
					"灵当CRM客户关系管理系统"
				],
				"江苏鹏为软件有限公司": [
					"CRM~E4",
					"企业垂直电商平台（基础包）",
					"“企达通”多社媒协同互动系统"
				],
				"南京管家婆软件有限公司": [
					"管家婆财贸双全",
					"管家婆工贸ERPT3",
					"管家婆分销批发平台（B2B）"
				],
				"南京新模式软件集成有限公司": [
					"文件加密系统",
					"文档管理软件",
					"内网安全管理软件"
				],
				"江苏天网计算机技术有限公司": [
					"天网WEB应用云防护服务",
					"天网WEB应用云监测服务"
				],
				"南京星霸科技有限公司": [
					"visTeam加密软件",
					"visTeamPDM图文档管理软件"
				],
				"南京壹进制信息技术股份有限公司": [
					"有数数据资产管理系统",
					"黑方实时数据备份与恢复系统",
					"秒匣实时数据备份与恢复系统"
				],
				"江苏移动信息系统集成有限公司": [
					"办公软件集成系统",
					"企业云存储",
					"云监控系统"
				],
				"朗坤智慧科技股份有限公司": [
					"“由你飞”运营管控平台-SAAS版",
					"“由你飞”运营管控平台-企业版"
				],
				"南京掌控网络科技有限公司": [
					"外勤365-定位版",
					"外勤365-商务版"
				],
				"南京佰腾发发信息科技有限公司": [
					"佰腾专利巴巴电商平台",
					"定制版专利管家"
				],
				"南京首屏商擎网络技术有限公司": [
					"百度搜索推广",
					"蚂蚁客服系统"
				],
				"斯坦德云科技股份有限公司": [
					"斯坦德云办公系统标准版",
					"斯坦德云办公系统增强版"
				],
				"南京睦泽信息科技有限公司": [
					"资质管理平台",
					"著作权在线申请平台"
				]
			}
		}

    function getOptions (data) {
    		if (!data) {
    			return  []
				}
        if (Object.prototype.toString.call(data) == "[object Object]") {
          var result = []
          for(var key in data) {
                result.push(key)
          }
          return result
        } else {
            return data
        }
    }

    function render (data, $el, selected) {
      var options = getOptions(data)

      var optionsStr = "<option value=''>请选择</option>"
      for(var i = 0; i< options.length; i++) {
          if($.trim(options[i]) == $.trim(selected)) {
						optionsStr += "<option value='"+ options[i] +"' selected>" + options[i]+"</option>"
          } else {
						optionsStr += "<option value='"+ options[i] +"'>" + options[i]+"</option>"
          }
      }

			$el.html($(optionsStr))
    }
    var $voucher =  $("#Js_voucher")
    var $year = $("#Js_year")
    var $company = $("#Js_company")
    var $product = $("#Js_product")
	  var selection = $voucher.val()

	  var selections = selection ? selection.split(",") : []
    render(voucherList, $year, selections[0])

    $product.change(function () {
        $voucher.val($year.val() + ',' + $company.val() + ',' + $(this).val())
    })
    $company.change(function () {
        render(voucherList[$year.val()] ? voucherList[$year.val()][$(this).val()] : '', $product, selections[2])
        $product.trigger("change")
    })
    $year.change(function () {
			render(voucherList[$(this).val()], $company, selections[1])
			$company.trigger("change")
    })

	  $year.trigger("change")

    $("#Js_form").formValidation({
				icon: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
        fields: {
            creditCode: {
                validators: {
                    notEmpty: {
                        message: '信用代码不能为空'
                    }
                }
            },
            companyName: {
                validators: {
                    notEmpty: {
                        message: '企业名称不能为空'
                    }
                }
            },
					regionId: {
                validators: {
                    notEmpty: {
                        message: '所属区不能为空'
                    }
                }
            },
            companyScale: {
                validators: {
                    notEmpty: {
                        message: '企业规模不能为空'
                    }
                }
            },
            artificialPerson: {
                validators: {
                    notEmpty: {
                        message: '法定代表人不能为空'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }
                }
            },
            establishDate: {
                validators: {
                    // notEmpty: {
                    //     message: '成立日期不能为空'
                    // }
                }
            },
            contacts: {
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    }
                }
            },
            phoneNo: {
                validators: {
                    notEmpty: {
                        message: '联系电话不能为空'
                    }
                }
            }
        }
    })

	var cropType = {
		"微型": "20人以下或年营业收入300万以下",
		"小型": "20-300人且年营业收入300-2000万",
		"中型": "300人以上且年营业收入2000万以上"
	}

	$('#Js_companyscale').change(function(){
		$('.Js_companyScale_desc').text(cropType[$(this).val()])
	}).trigger('change')
})