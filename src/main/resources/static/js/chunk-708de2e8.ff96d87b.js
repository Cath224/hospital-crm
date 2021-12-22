(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-708de2e8"],{1681:function(t,e,n){},"2bfd":function(t,e,n){},"85a8":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("medicine-component")},a=[],s=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"d-flex flex-row fill-height flex-grow-1"},[n("div",{staticClass:"d-flex flex-column fill-height flex-grow-1"},[n("div",{staticClass:"text-h4 my-2 mx-4"},[t._v("Medications")]),n("v-data-table",{staticClass:"ma-4 pa-4",attrs:{height:"60vh",headers:t.headers,items:t.items,loading:t.loading,search:t.search},scopedSlots:t._u([{key:"top",fn:function(){return[n("v-row",{attrs:{justify:"space-between"}},[n("v-col",{staticClass:"ma-2",attrs:{"align-self":"center",cols:"auto"}},[n("v-btn",{attrs:{color:"primary"},on:{click:function(e){t.patientDialog=!0}}},[t._v("Add")])],1),n("v-col",{staticClass:"ma-2",attrs:{"align-self":"center",cols:"5"}},[n("v-text-field",{attrs:{label:"Search"},model:{value:t.search,callback:function(e){t.search=e},expression:"search"}})],1)],1)]},proxy:!0},{key:"item.branchId",fn:function(t){var e=t.item;return[n("entity-table-field",{attrs:{"entity-store":"branches","entity-id-value":e.branchId}})]}},{key:"item.actions",fn:function(e){var i=e.item;return[n("v-icon",{staticClass:"mr-2",attrs:{small:""},on:{click:function(e){return t.editPatient(i)}}},[t._v(" mdi-pencil ")]),n("v-icon",{attrs:{small:""},on:{click:function(e){return t.deleteItem(i.id)}}},[t._v(" mdi-delete ")])]}}])})],1),n("entity-dialog",{attrs:{custom:""},on:{close:t.cancelCreationPatient},model:{value:t.patientDialog,callback:function(e){t.patientDialog=e},expression:"patientDialog"}},[t.patientDialog?n("medicine-form-component",{attrs:{type:null!=t.patientToChange?"edit":"create","input-entity":t.patientToChange},on:{entityChanged:t.patientChanged,cancelCreation:t.cancelCreationPatient}}):t._e()],1)],1)},l=[],o=(n("d3b7"),n("deba")),r=n("e00b"),c=n("b237"),u=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-card",{attrs:{loading:t.loading}},[n("v-card-title",[t._v(t._s("create"===t.type?"Create":"Edit")+" Medication")]),n("v-card-text",[t.entity?n("v-form",[n("v-row",{attrs:{align:"center"}},[n("v-col",{attrs:{"align-self":"center",cols:"5"}},[n("v-text-field",{attrs:{label:"Name"},model:{value:t.entity.name,callback:function(e){t.$set(t.entity,"name",e)},expression:"entity.name"}})],1),n("v-col",{attrs:{"align-self":"center",cols:"5"}},[n("v-text-field",{attrs:{type:"number",label:"Number"},model:{value:t.entity.number,callback:function(e){t.$set(t.entity,"number",e)},expression:"entity.number"}})],1)],1),n("v-row",{attrs:{align:"center"}},[n("v-col",{attrs:{"align-self":"center",cols:"5"}},[n("v-text-field",{attrs:{label:"Serial Number"},model:{value:t.entity.serialNumber,callback:function(e){t.$set(t.entity,"serialNumber",e)},expression:"entity.serialNumber"}})],1),n("v-col",{attrs:{"align-self":"center",cols:"5"}},[n("entity-autocomplete-field",{attrs:{"items-store-name":"branches",label:"Branch","item-text":"name"},model:{value:t.entity.branchId,callback:function(e){t.$set(t.entity,"branchId",e)},expression:"entity.branchId"}})],1)],1),n("v-row",{attrs:{align:"center"}},[n("v-col",{attrs:{"align-self":"center",cols:"10"}},[n("v-textarea",{attrs:{label:"Description"},model:{value:t.entity.description,callback:function(e){t.$set(t.entity,"description",e)},expression:"entity.description"}})],1)],1),n("v-row",{attrs:{align:"center"}},[n("v-col",{attrs:{"align-self":"center",cols:"10"}},[n("v-textarea",{attrs:{label:"Indications"},model:{value:t.entity.indications,callback:function(e){t.$set(t.entity,"indications",e)},expression:"entity.indications"}})],1)],1),n("v-row",{attrs:{align:"center"}},[n("v-col",{attrs:{"align-self":"center",cols:"10"}},[n("v-textarea",{attrs:{label:"Contraindications"},model:{value:t.entity.contraindications,callback:function(e){t.$set(t.entity,"contraindications",e)},expression:"entity.contraindications"}})],1)],1)],1):t._e()],1),n("v-card-actions",[n("div",{staticClass:"d-flex flex-row align-center justify-end flex-grow-1"},[n("v-btn",{staticClass:"mx-2",attrs:{color:"primary",text:""},on:{click:t.cancelCreatePatient}},[t._v("Cancel")]),n("v-btn",{staticClass:"mx-2",attrs:{color:"primary"},on:{click:t.changePatient}},[t._v(t._s("create"===t.type?"Create":"Edit"))])],1)])],1)},d=[],h=n("4979"),m=n("b4b4"),f={name:"MedicineFormComponent",components:{EntityAutocompleteField:m["a"]},props:{type:{type:String,default:"create"},inputEntity:{type:Object}},data:function(){return{entity:null,birthdayMenu:!1,loading:!1}},mounted:function(){this.entity="create"===this.type?{}:h(this.inputEntity)},methods:{changePatient:function(){var t=this;this.loading=!0,"create"===this.type?o["a"].get("MEDICINE").create(this.entity).then((function(e){t.$emit("entityChanged",e.data),t.cancelCreatePatient()})).catch((function(t){r["a"].$emit("error",t)})).finally((function(){t.loading=!1})):o["a"].get("MEDICINE").update(this.entity,this.entity.id).then((function(e){t.$emit("entityChanged",e.data),t.cancelCreatePatient()})).catch((function(t){r["a"].$emit("error",t)})).finally((function(){t.loading=!1}))},cancelCreatePatient:function(){this.$emit("cancelCreation")}}},p=f,g=n("2877"),v=n("6544"),y=n.n(v),I=n("8336"),b=n("b0af"),x=n("99d9"),S=n("62ad"),C=n("4bd4"),w=n("0fd9"),D=n("8654"),V=n("5530"),$=(n("a9e3"),n("1681"),n("58df")),T=Object($["a"])(D["a"]),k=T.extend({name:"v-textarea",props:{autoGrow:Boolean,noResize:Boolean,rowHeight:{type:[Number,String],default:24,validator:function(t){return!isNaN(parseFloat(t))}},rows:{type:[Number,String],default:5,validator:function(t){return!isNaN(parseInt(t,10))}}},computed:{classes:function(){return Object(V["a"])({"v-textarea":!0,"v-textarea--auto-grow":this.autoGrow,"v-textarea--no-resize":this.noResizeHandle},D["a"].options.computed.classes.call(this))},noResizeHandle:function(){return this.noResize||this.autoGrow}},watch:{autoGrow:function(t){var e=this;this.$nextTick((function(){var n;t?e.calculateInputHeight():null==(n=e.$refs.input)||n.style.removeProperty("height")}))},lazyValue:function(){this.autoGrow&&this.$nextTick(this.calculateInputHeight)},rowHeight:function(){this.autoGrow&&this.$nextTick(this.calculateInputHeight)}},mounted:function(){var t=this;setTimeout((function(){t.autoGrow&&t.calculateInputHeight()}),0)},methods:{calculateInputHeight:function(){var t=this.$refs.input;if(t){t.style.height="0";var e=t.scrollHeight,n=parseInt(this.rows,10)*parseFloat(this.rowHeight);t.style.height=Math.max(n,e)+"px"}},genInput:function(){var t=D["a"].options.methods.genInput.call(this);return t.tag="textarea",delete t.data.attrs.type,t.data.attrs.rows=this.rows,t},onInput:function(t){D["a"].options.methods.onInput.call(this,t),this.autoGrow&&this.calculateInputHeight()},onKeyDown:function(t){this.isFocused&&13===t.keyCode&&t.stopPropagation(),this.$emit("keydown",t)}}}),_=Object(g["a"])(p,u,d,!1,null,null,null),F=_.exports;y()(_,{VBtn:I["a"],VCard:b["a"],VCardActions:x["a"],VCardText:x["b"],VCardTitle:x["c"],VCol:S["a"],VForm:C["a"],VRow:w["a"],VTextField:D["a"],VTextarea:k});var j=n("d736"),N={name:"MedicineComponent",components:{EntityTableField:j["a"],MedicineFormComponent:F,EntityDialog:c["a"]},data:function(){return{search:null,headers:[{text:"Name",align:"start",sortable:!0,value:"name"},{text:"Serial Number",align:"start",sortable:!0,value:"serialNumber"},{text:"Branch",align:"start",sortable:!0,value:"branchId"},{text:"Description",align:"start",sortable:!0,value:"description"},{text:"Indications",align:"start",sortable:!0,value:"indications"},{text:"Contraindications",align:"start",sortable:!0,value:"contraindications"},{text:"Number",align:"start",sortable:!0,value:"number"},{text:"Actions",value:"actions",sortable:!1}],items:[],loading:!1,patientDialog:!1,patientToChange:null}},mounted:function(){this.loadItems()},methods:{loadItems:function(){var t=this;this.loading=!0,o["a"].get("MEDICINE").get(null).then((function(e){t.items=e.data})).catch((function(t){r["a"].$emit("error",t)})).finally((function(){t.loading=!1}))},editPatient:function(t){this.patientDialog=!0,this.patientToChange=t},patientChanged:function(){this.loadItems()},cancelCreationPatient:function(){this.patientDialog=!1},deleteItem:function(t){var e=this;o["a"].get("MEDICINE").deleteById(t).then((function(){e.loadItems()})).catch((function(t){r["a"].$emit("error",t)}))}}},O=N,M=n("8fea"),E=n("132d"),B=Object(g["a"])(O,s,l,!1,null,null,null),P=B.exports;y()(B,{VBtn:I["a"],VCol:S["a"],VDataTable:M["a"],VIcon:E["a"],VRow:w["a"],VTextField:D["a"]});var z={name:"MedicineView",components:{MedicineComponent:P}},A=z,R=Object(g["a"])(A,i,a,!1,null,null,null);e["default"]=R.exports},b4b4:function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"d-flex flex-row"},[n("v-autocomplete",{attrs:{value:t.dataValue,items:t.items,"item-value":t.itemKey,"item-text":t.itemText,loading:t.loading,label:t.label,"return-object":t.objectReturn,multiple:t.multi,clearable:""},on:{blur:function(e){t.lazyItemsLoading&&t.loadItems},input:t.input,"click:clear":t.input},scopedSlots:t._u([t.itemText?null:{key:"item",fn:function(e){var n=e.item;return[t._v(" "+t._s(t.getItemText(n))+" ")]}},t.itemText?null:{key:"selection",fn:function(e){var n=e.item;return[t._v(" "+t._s(t.getItemText(n))+" ")]}},{key:"append",fn:function(){return[n("div",[n("v-btn",{attrs:{icon:""},on:{click:t.loadItems}},[n("v-icon",[t._v("mdi-refresh")])],1)],1)]},proxy:!0}],null,!0)})],1)},a=[],s=n("5530"),l=(n("d3b7"),n("deba")),o=n("e00b"),r=n("2f62"),c={name:"EntityAutocompleteField",props:{value:{},itemsStoreName:{type:String},itemsRepositoryName:{type:String},itemKey:{type:String,default:function(){return"id"}},itemText:{type:String},lazyItemsLoading:{type:Boolean,default:!1},objectReturn:{type:Boolean,default:!1},itemTextFunction:{type:Function},label:{type:String,required:!0},multi:{type:Boolean,default:!1}},data:function(){return{dataValue:null,items:[],loading:!1}},computed:Object(s["a"])({},Object(r["b"])("content",{getContents:"getContents"})),watch:{value:{handler:function(t){this.dataValue=t},deep:!0,immediate:!0}},mounted:function(){this.dataValue=this.value,this.lazyItemsLoading||this.loadItems()},methods:{setValue:function(t){this.dataValue=t},getItemText:function(t){return null!=this.itemTextFunction?this.itemTextFunction(t):t},loadItems:function(){var t=this;if(this.loading=!0,this.itemsStoreName)this.items=this.getContents(this.itemsStoreName),this.loading=!1;else{var e=l["a"].get(this.itemsRepositoryName).get(null);e.then((function(e){t.items=e.data})).catch((function(t){o["a"].$emit("error",t)})).finally((function(){t.loading=!1}))}},input:function(t){this.$emit("input",t)}}},u=c,d=n("2877"),h=n("6544"),m=n.n(h),f=(n("d81d"),n("4de4"),n("498a"),n("7db0"),n("c740"),n("caad"),n("2532"),n("2bfd"),n("b974")),p=n("8654"),g=n("d9f7"),v=n("80d2"),y=Object(s["a"])(Object(s["a"])({},f["b"]),{},{offsetY:!0,offsetOverflow:!0,transition:!1}),I=f["a"].extend({name:"v-autocomplete",props:{allowOverflow:{type:Boolean,default:!0},autoSelectFirst:{type:Boolean,default:!1},filter:{type:Function,default:function(t,e,n){return n.toLocaleLowerCase().indexOf(e.toLocaleLowerCase())>-1}},hideNoData:Boolean,menuProps:{type:f["a"].options.props.menuProps.type,default:function(){return y}},noFilter:Boolean,searchInput:{type:String}},data:function(){return{lazySearch:this.searchInput}},computed:{classes:function(){return Object(s["a"])(Object(s["a"])({},f["a"].options.computed.classes.call(this)),{},{"v-autocomplete":!0,"v-autocomplete--is-selecting-index":this.selectedIndex>-1})},computedItems:function(){return this.filteredItems},selectedValues:function(){var t=this;return this.selectedItems.map((function(e){return t.getValue(e)}))},hasDisplayedItems:function(){var t=this;return this.hideSelected?this.filteredItems.some((function(e){return!t.hasItem(e)})):this.filteredItems.length>0},currentRange:function(){return null==this.selectedItem?0:String(this.getText(this.selectedItem)).length},filteredItems:function(){var t=this;return!this.isSearching||this.noFilter||null==this.internalSearch?this.allItems:this.allItems.filter((function(e){var n=Object(v["s"])(e,t.itemText),i=null!=n?String(n):"";return t.filter(e,String(t.internalSearch),i)}))},internalSearch:{get:function(){return this.lazySearch},set:function(t){this.lazySearch!==t&&(this.lazySearch=t,this.$emit("update:search-input",t))}},isAnyValueAllowed:function(){return!1},isDirty:function(){return this.searchIsDirty||this.selectedItems.length>0},isSearching:function(){return this.multiple&&this.searchIsDirty||this.searchIsDirty&&this.internalSearch!==this.getText(this.selectedItem)},menuCanShow:function(){return!!this.isFocused&&(this.hasDisplayedItems||!this.hideNoData)},$_menuProps:function(){var t=f["a"].options.computed.$_menuProps.call(this);return t.contentClass="v-autocomplete__content ".concat(t.contentClass||"").trim(),Object(s["a"])(Object(s["a"])({},y),t)},searchIsDirty:function(){return null!=this.internalSearch&&""!==this.internalSearch},selectedItem:function(){var t=this;return this.multiple?null:this.selectedItems.find((function(e){return t.valueComparator(t.getValue(e),t.getValue(t.internalValue))}))},listData:function(){var t=f["a"].options.computed.listData.call(this);return t.props=Object(s["a"])(Object(s["a"])({},t.props),{},{items:this.virtualizedItems,noFilter:this.noFilter||!this.isSearching||!this.filteredItems.length,searchInput:this.internalSearch}),t}},watch:{filteredItems:"onFilteredItemsChanged",internalValue:"setSearch",isFocused:function(t){t?(document.addEventListener("copy",this.onCopy),this.$refs.input&&this.$refs.input.select()):(document.removeEventListener("copy",this.onCopy),this.blur(),this.updateSelf())},isMenuActive:function(t){!t&&this.hasSlot&&(this.lazySearch=null)},items:function(t,e){e&&e.length||!this.hideNoData||!this.isFocused||this.isMenuActive||!t.length||this.activateMenu()},searchInput:function(t){this.lazySearch=t},internalSearch:"onInternalSearchChanged",itemText:"updateSelf"},created:function(){this.setSearch()},destroyed:function(){document.removeEventListener("copy",this.onCopy)},methods:{onFilteredItemsChanged:function(t,e){var n=this;if(t!==e){if(!this.autoSelectFirst){var i=e[this.$refs.menu.listIndex];i?this.setMenuIndex(t.findIndex((function(t){return t===i}))):this.setMenuIndex(-1),this.$emit("update:list-index",this.$refs.menu.listIndex)}this.$nextTick((function(){n.internalSearch&&(1===t.length||n.autoSelectFirst)&&(n.$refs.menu.getTiles(),n.autoSelectFirst&&t.length&&(n.setMenuIndex(0),n.$emit("update:list-index",n.$refs.menu.listIndex)))}))}},onInternalSearchChanged:function(){this.updateMenuDimensions()},updateMenuDimensions:function(){this.isMenuActive&&this.$refs.menu&&this.$refs.menu.updateDimensions()},changeSelectedIndex:function(t){this.searchIsDirty||(this.multiple&&t===v["y"].left?-1===this.selectedIndex?this.selectedIndex=this.selectedItems.length-1:this.selectedIndex--:this.multiple&&t===v["y"].right?this.selectedIndex>=this.selectedItems.length-1?this.selectedIndex=-1:this.selectedIndex++:t!==v["y"].backspace&&t!==v["y"].delete||this.deleteCurrentItem())},deleteCurrentItem:function(){var t=this.selectedIndex,e=this.selectedItems[t];if(this.isInteractive&&!this.getDisabled(e)){var n=this.selectedItems.length-1;if(-1!==this.selectedIndex||0===n){var i=this.selectedItems.length,a=t!==i-1?t:t-1,s=this.selectedItems[a];s?this.selectItem(e):this.setValue(this.multiple?[]:null),this.selectedIndex=a}else this.selectedIndex=n}},clearableCallback:function(){this.internalSearch=null,f["a"].options.methods.clearableCallback.call(this)},genInput:function(){var t=p["a"].options.methods.genInput.call(this);return t.data=Object(g["a"])(t.data,{attrs:{"aria-activedescendant":Object(v["q"])(this.$refs.menu,"activeTile.id"),autocomplete:Object(v["q"])(t.data,"attrs.autocomplete","off")},domProps:{value:this.internalSearch}}),t},genInputSlot:function(){var t=f["a"].options.methods.genInputSlot.call(this);return t.data.attrs.role="combobox",t},genSelections:function(){return this.hasSlot||this.multiple?f["a"].options.methods.genSelections.call(this):[]},onClick:function(t){this.isInteractive&&(this.selectedIndex>-1?this.selectedIndex=-1:this.onFocus(),this.isAppendInner(t.target)||this.activateMenu())},onInput:function(t){if(!(this.selectedIndex>-1)&&t.target){var e=t.target,n=e.value;e.value&&this.activateMenu(),this.multiple||""!==n||this.deleteCurrentItem(),this.internalSearch=n,this.badInput=e.validity&&e.validity.badInput}},onKeyDown:function(t){var e=t.keyCode;!t.ctrlKey&&[v["y"].home,v["y"].end].includes(e)||f["a"].options.methods.onKeyDown.call(this,t),this.changeSelectedIndex(e)},onSpaceDown:function(t){},onTabDown:function(t){f["a"].options.methods.onTabDown.call(this,t),this.updateSelf()},onUpDown:function(t){t.preventDefault(),this.activateMenu()},selectItem:function(t){f["a"].options.methods.selectItem.call(this,t),this.setSearch()},setSelectedItems:function(){f["a"].options.methods.setSelectedItems.call(this),this.isFocused||this.setSearch()},setSearch:function(){var t=this;this.$nextTick((function(){t.multiple&&t.internalSearch&&t.isMenuActive||(t.internalSearch=!t.selectedItems.length||t.multiple||t.hasSlot?null:t.getText(t.selectedItem))}))},updateSelf:function(){(this.searchIsDirty||this.internalValue)&&(this.multiple||this.valueComparator(this.internalSearch,this.getValue(this.internalValue))||this.setSearch())},hasItem:function(t){return this.selectedValues.indexOf(this.getValue(t))>-1},onCopy:function(t){var e,n;if(-1!==this.selectedIndex){var i=this.selectedItems[this.selectedIndex],a=this.getText(i);null==(e=t.clipboardData)||e.setData("text/plain",a),null==(n=t.clipboardData)||n.setData("text/vnd.vuetify.autocomplete.item+plain",a),t.preventDefault()}}}}),b=n("8336"),x=n("132d"),S=Object(d["a"])(u,i,a,!1,null,null,null);e["a"]=S.exports;m()(S,{VAutocomplete:I,VBtn:b["a"],VIcon:x["a"]})},d736:function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"d-flex flex-row flex-grow-1"},[!t.loading&&t.item?n("div",[t._v(t._s(t.item[t.entityField]))]):t.loading?n("div",[n("v-progress-circular",{attrs:{color:"primary"}})],1):t._e()])},a=[],s=n("5530"),l=(n("d3b7"),n("e00b")),o=n("deba"),r=n("2f62"),c={name:"EntityTableField",props:{entityRepository:{type:String,required:!1},entityStore:{type:String,required:!1},entityField:{type:String,default:"name"},entityIdValue:{type:String,required:!0}},data:function(){return{loading:!1,item:null}},computed:Object(s["a"])({},Object(r["b"])("content",{getContentById:"getContentById"})),watch:{entityIdValue:{handler:function(t,e){t!==e&&this.loadItem()},immediate:!0}},methods:{loadItem:function(){var t=this;this.loading=!0,this.entityStore?(this.item=this.getContentById(this.entityStore,this.entityIdValue),this.loading=!1):o["a"].get(this.entityRepository).getById(this.entityIdValue).then((function(e){t.item=e.data})).catch((function(t){l["a"].$emit("error",t)})).finally((function(){t.loading=!1}))}}},u=c,d=n("2877"),h=n("6544"),m=n.n(h),f=n("490a"),p=Object(d["a"])(u,i,a,!1,null,null,null);e["a"]=p.exports;m()(p,{VProgressCircular:f["a"]})}}]);
//# sourceMappingURL=chunk-708de2e8.ff96d87b.js.map