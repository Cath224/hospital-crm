(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c13f4"],{"44db":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("patients-component")},i=[],s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"d-flex flex-row fill-height flex-grow-1"},[a("div",{staticClass:"d-flex flex-column fill-height flex-grow-1"},[a("div",{staticClass:"text-h4 my-2 mx-4"},[t._v("Patients")]),a("v-data-table",{staticClass:"ma-4 pa-4",attrs:{height:"60vh",headers:t.headers,items:t.items,loading:t.loading,search:t.search},scopedSlots:t._u([{key:"top",fn:function(){return[a("v-row",{attrs:{justify:"space-between"}},[a("v-col",{staticClass:"ma-2",attrs:{"align-self":"center",cols:"auto"}},[a("v-btn",{attrs:{color:"primary"},on:{click:function(e){t.patientDialog=!0}}},[t._v("Add")])],1),a("v-col",{staticClass:"ma-2",attrs:{"align-self":"center",cols:"5"}},[a("v-text-field",{attrs:{label:"Search"},model:{value:t.search,callback:function(e){t.search=e},expression:"search"}})],1)],1)]},proxy:!0},{key:"item.actions",fn:function(e){var n=e.item;return[a("v-icon",{staticClass:"mr-2",attrs:{small:""},on:{click:function(e){return t.editPatient(n)}}},[t._v(" mdi-pencil ")]),a("v-icon",{staticClass:"mr-2",attrs:{small:""},on:{click:function(e){return t.deleteItem(n.id)}}},[t._v(" mdi-delete ")]),a("v-icon",{attrs:{small:""},on:{click:function(e){return t.showDiagnoses(n.id)}}},[t._v(" mdi-order-bool-ascending ")])]}}])})],1),a("entity-dialog",{attrs:{custom:""},on:{close:t.cancelCreationPatient},model:{value:t.patientDialog,callback:function(e){t.patientDialog=e},expression:"patientDialog"}},[t.patientDialog?a("patient-form-component",{attrs:{type:null!=t.patientToChange?"edit":"create","input-entity":t.patientToChange},on:{entityChanged:t.patientChanged,cancelCreation:t.cancelCreationPatient}}):t._e()],1),a("entity-dialog",{attrs:{custom:""},on:{close:t.closeDiagnoses},model:{value:t.diagnosesDialog,callback:function(e){t.diagnosesDialog=e},expression:"diagnosesDialog"}},[t.diagnosesDialog&&t.diagnosesPatientId?a("patient-diagnosis-component",{attrs:{"patient-id":t.diagnosesPatientId},on:{closeDiagnosis:t.closeDiagnoses}}):t._e()],1)],1)},o=[],l=(a("d3b7"),a("deba")),c=a("e00b"),r=a("b237"),d=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-card",{attrs:{loading:t.loading}},[a("v-card-title",[t._v(t._s("create"===t.type?"Create":"Edit")+" Patient")]),a("v-card-text",[t.entity?a("v-form",[a("v-row",{attrs:{align:"center"}},[a("v-col",{attrs:{"align-self":"center",cols:"5"}},[a("v-text-field",{attrs:{label:"First Name"},model:{value:t.entity.firstName,callback:function(e){t.$set(t.entity,"firstName",e)},expression:"entity.firstName"}})],1),a("v-col",{attrs:{"align-self":"center",cols:"5"}},[a("v-text-field",{attrs:{label:"Last Name"},model:{value:t.entity.lastName,callback:function(e){t.$set(t.entity,"lastName",e)},expression:"entity.lastName"}})],1)],1),a("v-row",{attrs:{align:"center"}},[a("v-col",{attrs:{"align-self":"center",cols:"5"}},[a("v-menu",{attrs:{"close-on-content-click":!1,"nudge-right":40,transition:"scale-transition","offset-y":"","min-width":"auto"},scopedSlots:t._u([{key:"activator",fn:function(e){var n=e.on,i=e.attrs;return[a("v-text-field",t._g(t._b({attrs:{label:"Birthday","prepend-icon":"mdi-calendar",readonly:""},model:{value:t.entity.birthday,callback:function(e){t.$set(t.entity,"birthday",e)},expression:"entity.birthday"}},"v-text-field",i,!1),n))]}}],null,!1,4102699543),model:{value:t.birthdayMenu,callback:function(e){t.birthdayMenu=e},expression:"birthdayMenu"}},[a("v-date-picker",{on:{input:function(e){t.birthdayMenu=!1}},model:{value:t.entity.birthday,callback:function(e){t.$set(t.entity,"birthday",e)},expression:"entity.birthday"}})],1)],1),a("v-col",{attrs:{"align-self":"center",cols:"5"}},[a("v-text-field",{attrs:{type:"number",label:"Phone"},model:{value:t.entity.phone,callback:function(e){t.$set(t.entity,"phone",e)},expression:"entity.phone"}})],1)],1),a("v-row",{attrs:{align:"center"}},[a("v-col",{attrs:{"align-self":"center",cols:"5"}},[a("v-select",{attrs:{label:"Sex",items:["M","F"]},model:{value:t.entity.sex,callback:function(e){t.$set(t.entity,"sex",e)},expression:"entity.sex"}})],1)],1)],1):t._e()],1),a("v-card-actions",[a("div",{staticClass:"d-flex flex-row align-center justify-end flex-grow-1"},[a("v-btn",{staticClass:"mx-2",attrs:{color:"primary",text:""},on:{click:t.cancelCreatePatient}},[t._v("Cancel")]),a("v-btn",{staticClass:"mx-2",attrs:{color:"primary"},on:{click:t.changePatient}},[t._v(t._s("create"===t.type?"Create":"Edit"))])],1)])],1)},u=[],f=a("4979"),g={name:"PatientFormComponent",props:{type:{type:String,default:"create"},inputEntity:{type:Object}},data:function(){return{entity:null,birthdayMenu:!1,loading:!1}},mounted:function(){this.entity="create"===this.type?{}:f(this.inputEntity)},methods:{changePatient:function(){var t=this;this.loading=!0,"create"===this.type?l["a"].get("PATIENT").create(this.entity).then((function(e){t.$emit("entityChanged",e.data),t.cancelCreatePatient()})).catch((function(t){c["a"].$emit("error",t)})).finally((function(){t.loading=!1})):l["a"].get("PATIENT").update(this.entity,this.entity.id).then((function(e){t.$emit("entityChanged",e.data),t.cancelCreatePatient()})).catch((function(t){c["a"].$emit("error",t)})).finally((function(){t.loading=!1}))},cancelCreatePatient:function(){this.$emit("cancelCreation")}}},h=g,m=a("2877"),v=a("6544"),p=a.n(v),y=a("8336"),b=a("b0af"),x=a("99d9"),C=a("62ad"),D=a("2e4b"),P=a("4bd4"),_=a("e449"),w=a("0fd9"),k=a("b974"),I=a("8654"),V=Object(m["a"])(h,d,u,!1,null,null,null),T=V.exports;p()(V,{VBtn:y["a"],VCard:b["a"],VCardActions:x["a"],VCardText:x["b"],VCardTitle:x["c"],VCol:C["a"],VDatePicker:D["a"],VForm:P["a"],VMenu:_["a"],VRow:w["a"],VSelect:k["a"],VTextField:I["a"]});var $=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"d-flex flex-row align-center justify-center"},[a("v-card",{staticClass:"d-flex flex-column",attrs:{height:"80vh",width:"90vw"}},[a("v-card-text",t._l(t.diagnoses,(function(e){return a("v-card",{key:e.id,attrs:{flat:"",outlined:"",rounded:""}},[a("v-card-title",[t._v(t._s(e.date))]),a("v-card-text",[a("div",[t._v(t._s(e.description))])])],1)})),1),a("v-spacer"),a("v-card-actions",[a("div",{staticClass:"d-flex flex-row align-center justify-end flex-grow-1"},[a("v-btn",{staticClass:"mx-2",attrs:{color:"primary"},on:{click:t.loadDiagnosis}},[t._v("Reload")]),a("v-btn",{staticClass:"mx-2",attrs:{color:"primary",text:""},on:{click:function(e){return t.$emit("closeDiagnosis")}}},[t._v("Cancel")])],1)])],1)],1)},N=[],E=a("b85c"),S=(a("a4d3"),a("e01a"),{name:"PatientDiagnosisComponent",props:{patientId:{type:String,required:!0}},data:function(){return{diagnoses:[]}},watch:{patientId:{handler:function(){this.loadDiagnosis()},deep:!0}},mounted:function(){this.loadDiagnosis()},methods:{loadDiagnosis:function(){var t=this;l["a"].get("PATIENT_VISIT").get("patientId==".concat(this.patientId)).then((function(e){var a,n=e.data,i=[],s=Object(E["a"])(n);try{var o=function(){var t=a.value;l["a"].get("DIAGNOSIS").get("patientVisitId==".concat(t.id)).then((function(e){var a,n=e.data,s=Object(E["a"])(n);try{for(s.s();!(a=s.n()).done;){var o=a.value;i.push({id:o.id,date:new Date(t.actualTimestamp),description:o.description})}}catch(l){s.e(l)}finally{s.f()}})).catch((function(t){c["a"].$emit("error",t)}))};for(s.s();!(a=s.n()).done;)o()}catch(r){s.e(r)}finally{s.f()}t.diagnoses=i})).catch((function(t){c["a"].$emit("error",t)}))}}}),j=S,A=a("2fa4"),F=Object(m["a"])(j,$,N,!1,null,null,null),O=F.exports;p()(F,{VBtn:y["a"],VCard:b["a"],VCardActions:x["a"],VCardText:x["b"],VCardTitle:x["c"],VSpacer:A["a"]});var M={name:"PatientsComponent",components:{PatientDiagnosisComponent:O,PatientFormComponent:T,EntityDialog:r["a"]},data:function(){return{search:null,headers:[{text:"First Name",align:"start",sortable:!0,value:"firstName"},{text:"Last Name",align:"start",sortable:!0,value:"lastName"},{text:"Sex",align:"start",sortable:!0,value:"sex"},{text:"Birthday",align:"start",sortable:!0,value:"birthday"},{text:"Phone",align:"start",sortable:!0,value:"phone"},{text:"Actions",value:"actions",sortable:!1}],items:[],loading:!1,patientDialog:!1,diagnosesDialog:!1,diagnosesPatientId:null,patientToChange:null}},mounted:function(){this.loadItems()},methods:{loadItems:function(){var t=this;this.loading=!0,l["a"].get("PATIENT").get(null).then((function(e){t.items=e.data})).catch((function(t){c["a"].$emit("error",t)})).finally((function(){t.loading=!1}))},editPatient:function(t){this.patientDialog=!0,this.patientToChange=t},patientChanged:function(){this.loadItems()},cancelCreationPatient:function(){this.patientDialog=!1},deleteItem:function(t){var e=this;l["a"].get("PATIENT").deleteById(t).then((function(){e.loadItems()})).catch((function(t){c["a"].$emit("error",t)}))},showDiagnoses:function(t){this.diagnosesDialog=!0,this.diagnosesPatientId=t},closeDiagnoses:function(){this.diagnosesDialog=!1,this.diagnosesPatientId=null}}},B=M,R=a("8fea"),J=a("132d"),L=Object(m["a"])(B,s,o,!1,null,null,null),q=L.exports;p()(L,{VBtn:y["a"],VCol:C["a"],VDataTable:R["a"],VIcon:J["a"],VRow:w["a"],VTextField:I["a"]});var G={name:"PatientsView",components:{PatientsComponent:q}},z=G,H=Object(m["a"])(z,n,i,!1,null,null,null);e["default"]=H.exports}}]);
//# sourceMappingURL=chunk-2d0c13f4.a23729a3.js.map