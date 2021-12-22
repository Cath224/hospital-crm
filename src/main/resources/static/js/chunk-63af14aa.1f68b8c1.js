(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-63af14aa"],{"297c":function(t,e,a){"use strict";a("a9e3");var i=a("2b0e"),r=a("5530"),n=a("ade3"),s=(a("c7cd"),a("6ece"),a("0789")),o=a("90a2"),l=a("a9ad"),c=a("fe6c"),h=a("a452"),u=a("7560"),d=a("80d2"),f=a("58df"),g=Object(f["a"])(l["a"],Object(c["b"])(["absolute","fixed","top","bottom"]),h["a"],u["a"]),m=g.extend({name:"v-progress-linear",directives:{intersect:o["a"]},props:{active:{type:Boolean,default:!0},backgroundColor:{type:String,default:null},backgroundOpacity:{type:[Number,String],default:null},bufferValue:{type:[Number,String],default:100},color:{type:String,default:"primary"},height:{type:[Number,String],default:4},indeterminate:Boolean,query:Boolean,reverse:Boolean,rounded:Boolean,stream:Boolean,striped:Boolean,value:{type:[Number,String],default:0}},data:function(){return{internalLazyValue:this.value||0,isVisible:!0}},computed:{__cachedBackground:function(){return this.$createElement("div",this.setBackgroundColor(this.backgroundColor||this.color,{staticClass:"v-progress-linear__background",style:this.backgroundStyle}))},__cachedBar:function(){return this.$createElement(this.computedTransition,[this.__cachedBarType])},__cachedBarType:function(){return this.indeterminate?this.__cachedIndeterminate:this.__cachedDeterminate},__cachedBuffer:function(){return this.$createElement("div",{staticClass:"v-progress-linear__buffer",style:this.styles})},__cachedDeterminate:function(){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__determinate",style:{width:Object(d["h"])(this.normalizedValue,"%")}}))},__cachedIndeterminate:function(){return this.$createElement("div",{staticClass:"v-progress-linear__indeterminate",class:{"v-progress-linear__indeterminate--active":this.active}},[this.genProgressBar("long"),this.genProgressBar("short")])},__cachedStream:function(){return this.stream?this.$createElement("div",this.setTextColor(this.color,{staticClass:"v-progress-linear__stream",style:{width:Object(d["h"])(100-this.normalizedBuffer,"%")}})):null},backgroundStyle:function(){var t,e=null==this.backgroundOpacity?this.backgroundColor?1:.3:parseFloat(this.backgroundOpacity);return t={opacity:e},Object(n["a"])(t,this.isReversed?"right":"left",Object(d["h"])(this.normalizedValue,"%")),Object(n["a"])(t,"width",Object(d["h"])(Math.max(0,this.normalizedBuffer-this.normalizedValue),"%")),t},classes:function(){return Object(r["a"])({"v-progress-linear--absolute":this.absolute,"v-progress-linear--fixed":this.fixed,"v-progress-linear--query":this.query,"v-progress-linear--reactive":this.reactive,"v-progress-linear--reverse":this.isReversed,"v-progress-linear--rounded":this.rounded,"v-progress-linear--striped":this.striped,"v-progress-linear--visible":this.isVisible},this.themeClasses)},computedTransition:function(){return this.indeterminate?s["c"]:s["d"]},isReversed:function(){return this.$vuetify.rtl!==this.reverse},normalizedBuffer:function(){return this.normalize(this.bufferValue)},normalizedValue:function(){return this.normalize(this.internalLazyValue)},reactive:function(){return Boolean(this.$listeners.change)},styles:function(){var t={};return this.active||(t.height=0),this.indeterminate||100===parseFloat(this.normalizedBuffer)||(t.width=Object(d["h"])(this.normalizedBuffer,"%")),t}},methods:{genContent:function(){var t=Object(d["t"])(this,"default",{value:this.internalLazyValue});return t?this.$createElement("div",{staticClass:"v-progress-linear__content"},t):null},genListeners:function(){var t=this.$listeners;return this.reactive&&(t.click=this.onClick),t},genProgressBar:function(t){return this.$createElement("div",this.setBackgroundColor(this.color,{staticClass:"v-progress-linear__indeterminate",class:Object(n["a"])({},t,!0)}))},onClick:function(t){if(this.reactive){var e=this.$el.getBoundingClientRect(),a=e.width;this.internalValue=t.offsetX/a*100}},onObserve:function(t,e,a){this.isVisible=a},normalize:function(t){return t<0?0:t>100?100:parseFloat(t)}},render:function(t){var e={staticClass:"v-progress-linear",attrs:{role:"progressbar","aria-valuemin":0,"aria-valuemax":this.normalizedBuffer,"aria-valuenow":this.indeterminate?void 0:this.normalizedValue},class:this.classes,directives:[{name:"intersect",value:this.onObserve}],style:{bottom:this.bottom?0:void 0,height:this.active?Object(d["h"])(this.height):0,top:this.top?0:void 0},on:this.genListeners()};return t("div",e,[this.__cachedStream,this.__cachedBackground,this.__cachedBuffer,this.__cachedBar,this.genContent()])}}),p=m;e["a"]=i["a"].extend().extend({name:"loadable",props:{loading:{type:[Boolean,String],default:!1},loaderHeight:{type:[Number,String],default:2}},methods:{genProgress:function(){return!1===this.loading?null:this.$slots.progress||this.$createElement(p,{props:{absolute:!0,color:!0===this.loading||""===this.loading?this.color||"primary":this.loading,height:this.loaderHeight,indeterminate:!0}})}}})},"615b":function(t,e,a){},"6ece":function(t,e,a){},"99d9":function(t,e,a){"use strict";a.d(e,"a",(function(){return n})),a.d(e,"b",(function(){return o})),a.d(e,"c",(function(){return l}));var i=a("b0af"),r=a("80d2"),n=Object(r["j"])("v-card__actions"),s=Object(r["j"])("v-card__subtitle"),o=Object(r["j"])("v-card__text"),l=Object(r["j"])("v-card__title");i["a"]},b0af:function(t,e,a){"use strict";var i=a("5530"),r=(a("a9e3"),a("0481"),a("4069"),a("615b"),a("10d2")),n=a("297c"),s=a("1c87"),o=a("58df");e["a"]=Object(o["a"])(n["a"],s["a"],r["a"]).extend({name:"v-card",props:{flat:Boolean,hover:Boolean,img:String,link:Boolean,loaderHeight:{type:[Number,String],default:4},raised:Boolean},computed:{classes:function(){return Object(i["a"])(Object(i["a"])({"v-card":!0},s["a"].options.computed.classes.call(this)),{},{"v-card--flat":this.flat,"v-card--hover":this.hover,"v-card--link":this.isClickable,"v-card--loading":this.loading,"v-card--disabled":this.disabled,"v-card--raised":this.raised},r["a"].options.computed.classes.call(this))},styles:function(){var t=Object(i["a"])({},r["a"].options.computed.styles.call(this));return this.img&&(t.background='url("'.concat(this.img,'") center center / cover no-repeat')),t}},methods:{genProgress:function(){var t=n["a"].options.methods.genProgress.call(this);return t?this.$createElement("div",{staticClass:"v-card__progress",key:"progress"},[t]):null}},render:function(t){var e=this.generateRouteLink(),a=e.tag,i=e.data;return i.style=this.styles,this.isClickable&&(i.attrs=i.attrs||{},i.attrs.tabindex=0),t(a,this.setBackgroundColor(this.color,i),[this.genProgress(),this.$slots.default])}})},bb51:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("dashboard-component")],1)},r=[],n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"d-flex flex-row fill-height flex-grow-1"},[a("div",{staticClass:"d-flex flex-column fill-height flex-grow-1"},[a("div",{staticClass:"text-h4 my-2 mx-4"},[t._v("Dashboard")]),a("v-card",{staticClass:"fill-height",attrs:{height:"80vh",width:"80vw"}},[a("v-card-title",[t._v("Patients Statistics by month")]),a("v-card-text",[a("v-sparkline",{attrs:{fill:"",gradient:["#00c6ff","#F0F","#FF0"],smooth:10,value:t.patientsStatistics,labels:t.labels,"show-labels":"","auto-draw":""}})],1)],1)],1)])},s=[],o=a("b85c"),l=a("5530"),c=a("deba"),h=a("e00b"),u=a("2f62"),d={name:"DashboardComponent",data:function(){return{labels:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],patientsStatistics:[0,0,0,0,0,0,0,0,0,0,0,0]}},computed:Object(l["a"])({},Object(u["b"])("configuration",{getSelectedDoctor:"getSelectedDoctor"})),mounted:function(){this.loadStatistics()},methods:{loadStatistics:function(){var t,e=this;c["a"].get("PATIENT_VISIT").getStatistics(null===(t=this.getSelectedDoctor)||void 0===t?void 0:t.id).then((function(t){var a,i=t.data,r=Object(o["a"])(i);try{for(r.s();!(a=r.n()).done;){var n=a.value;e.patientsStatistics[n.month-1]=n.numberOfPatients}}catch(s){r.e(s)}finally{r.f()}})).catch((function(t){h["a"].$emit("error",t)}))}}},f=d,g=a("2877"),m=a("6544"),p=a.n(m),b=a("b0af"),v=a("99d9"),y=a("53ca"),x=(a("a9e3"),a("caad"),a("d81d"),a("cb29"),a("d3b7"),a("25f0"),a("99af"),a("fb6a"),a("a9ad")),_=a("58df"),S=a("2909");function B(t,e){var a=e.minX,i=e.maxX,r=e.minY,n=e.maxY,s=t.length,o=Math.max.apply(Math,Object(S["a"])(t)),l=Math.min.apply(Math,Object(S["a"])(t)),c=(i-a)/(s-1),h=(n-r)/(o-l||1);return t.map((function(t,e){return{x:a+e*c,y:n-(t-l)*h,value:t}}))}function O(t,e){var a=e.minX,i=e.maxX,r=e.minY,n=e.maxY,s=t.length,o=Math.max.apply(Math,Object(S["a"])(t)),l=Math.min.apply(Math,Object(S["a"])(t));l>0&&(l=0),o<0&&(o=0);var c=i/s,h=(n-r)/(o-l||1),u=n-Math.abs(l*h);return t.map((function(t,e){var i=Math.abs(h*t);return{x:a+e*c,y:u-i+ +(t<0)*i,height:i,value:t}}))}a("a15b");function k(t){return parseInt(t,10)}function w(t,e,a){return k(t.x+a.x)===k(2*e.x)&&k(t.y+a.y)===k(2*e.y)}function C(t,e){return Math.sqrt(Math.pow(e.x-t.x,2)+Math.pow(e.y-t.y,2))}function j(t,e,a){var i={x:t.x-e.x,y:t.y-e.y},r=Math.sqrt(i.x*i.x+i.y*i.y),n={x:i.x/r,y:i.y/r};return{x:e.x+n.x*a,y:e.y+n.y*a}}function $(t,e){var a=arguments.length>2&&void 0!==arguments[2]&&arguments[2],i=arguments.length>3&&void 0!==arguments[3]?arguments[3]:75,r=t.shift(),n=t[t.length-1];return(a?"M".concat(r.x," ").concat(i-r.x+2," L").concat(r.x," ").concat(r.y):"M".concat(r.x," ").concat(r.y))+t.map((function(a,i){var n=t[i+1],s=t[i-1]||r,o=n&&w(n,a,s);if(!n||o)return"L".concat(a.x," ").concat(a.y);var l=Math.min(C(s,a),C(n,a)),c=l/2<e,h=c?l/2:e,u=j(s,a,h),d=j(n,a,h);return"L".concat(u.x," ").concat(u.y,"S").concat(a.x," ").concat(a.y," ").concat(d.x," ").concat(d.y)})).join("")+(a?"L".concat(n.x," ").concat(i-r.x+2," Z"):"")}var z=Object(_["a"])(x["a"]).extend({name:"VSparkline",inheritAttrs:!1,props:{autoDraw:Boolean,autoDrawDuration:{type:Number,default:2e3},autoDrawEasing:{type:String,default:"ease"},autoLineWidth:{type:Boolean,default:!1},color:{type:String,default:"primary"},fill:{type:Boolean,default:!1},gradient:{type:Array,default:function(){return[]}},gradientDirection:{type:String,validator:function(t){return["top","bottom","left","right"].includes(t)},default:"top"},height:{type:[String,Number],default:75},labels:{type:Array,default:function(){return[]}},labelSize:{type:[Number,String],default:7},lineWidth:{type:[String,Number],default:4},padding:{type:[String,Number],default:8},showLabels:Boolean,smooth:{type:[Boolean,Number,String],default:!1},type:{type:String,default:"trend",validator:function(t){return["trend","bar"].includes(t)}},value:{type:Array,default:function(){return[]}},width:{type:[Number,String],default:300}},data:function(){return{lastLength:0}},computed:{parsedPadding:function(){return Number(this.padding)},parsedWidth:function(){return Number(this.width)},parsedHeight:function(){return parseInt(this.height,10)},parsedLabelSize:function(){return parseInt(this.labelSize,10)||7},totalHeight:function(){var t=this.parsedHeight;return this.hasLabels&&(t+=1.5*parseInt(this.labelSize,10)),t},totalWidth:function(){var t=this.parsedWidth;return"bar"===this.type&&(t=Math.max(this.value.length*this._lineWidth,t)),t},totalValues:function(){return this.value.length},_lineWidth:function(){if(this.autoLineWidth&&"trend"!==this.type){var t=this.parsedPadding*(this.totalValues+1);return(this.parsedWidth-t)/this.totalValues}return parseFloat(this.lineWidth)||4},boundary:function(){if("bar"===this.type)return{minX:0,maxX:this.totalWidth,minY:0,maxY:this.parsedHeight};var t=this.parsedPadding;return{minX:t,maxX:this.totalWidth-t,minY:t,maxY:this.parsedHeight-t}},hasLabels:function(){return Boolean(this.showLabels||this.labels.length>0||this.$scopedSlots.label)},parsedLabels:function(){for(var t=[],e=this._values,a=e.length,i=0;t.length<a;i++){var r=e[i],n=this.labels[i];n||(n="object"===Object(y["a"])(r)?r.value:r),t.push({x:r.x,value:String(n)})}return t},normalizedValues:function(){return this.value.map((function(t){return"number"===typeof t?t:t.value}))},_values:function(){return"trend"===this.type?B(this.normalizedValues,this.boundary):O(this.normalizedValues,this.boundary)},textY:function(){var t=this.parsedHeight;return"trend"===this.type&&(t-=4),t},_radius:function(){return!0===this.smooth?8:Number(this.smooth)}},watch:{value:{immediate:!0,handler:function(){var t=this;this.$nextTick((function(){if(t.autoDraw&&"bar"!==t.type&&t.$refs.path){var e=t.$refs.path,a=e.getTotalLength();t.fill?(e.style.transformOrigin="bottom center",e.style.transition="none",e.style.transform="scaleY(0)",e.getBoundingClientRect(),e.style.transition="transform ".concat(t.autoDrawDuration,"ms ").concat(t.autoDrawEasing),e.style.transform="scaleY(1)"):(e.style.transition="none",e.style.strokeDasharray=a+" "+a,e.style.strokeDashoffset=Math.abs(a-(t.lastLength||0)).toString(),e.getBoundingClientRect(),e.style.transition="stroke-dashoffset ".concat(t.autoDrawDuration,"ms ").concat(t.autoDrawEasing),e.style.strokeDashoffset="0"),t.lastLength=a}}))}}},methods:{genGradient:function(){var t=this,e=this.gradientDirection,a=this.gradient.slice();a.length||a.push("");var i=Math.max(a.length-1,1),r=a.reverse().map((function(e,a){return t.$createElement("stop",{attrs:{offset:a/i,"stop-color":e||"currentColor"}})}));return this.$createElement("defs",[this.$createElement("linearGradient",{attrs:{id:this._uid,gradientUnits:"userSpaceOnUse",x1:"left"===e?"100%":"0",y1:"top"===e?"100%":"0",x2:"right"===e?"100%":"0",y2:"bottom"===e?"100%":"0"}},r)])},genG:function(t){return this.$createElement("g",{style:{fontSize:"8",textAnchor:"middle",dominantBaseline:"mathematical",fill:"currentColor"}},t)},genPath:function(){var t=B(this.normalizedValues,this.boundary);return this.$createElement("path",{attrs:{d:$(t,this._radius,this.fill,this.parsedHeight),fill:this.fill?"url(#".concat(this._uid,")"):"none",stroke:this.fill?"none":"url(#".concat(this._uid,")")},ref:"path"})},genLabels:function(t){var e=this,a=this.parsedLabels.map((function(a,i){return e.$createElement("text",{attrs:{x:a.x+t+e._lineWidth/2,y:e.textY+.75*e.parsedLabelSize,"font-size":Number(e.labelSize)||7}},[e.genLabel(a,i)])}));return this.genG(a)},genLabel:function(t,e){return this.$scopedSlots.label?this.$scopedSlots.label({index:e,value:t.value}):t.value},genBars:function(){if(this.value&&!(this.totalValues<2)){var t=O(this.normalizedValues,this.boundary),e=(Math.abs(t[0].x-t[1].x)-this._lineWidth)/2;return this.$createElement("svg",{attrs:{display:"block",viewBox:"0 0 ".concat(this.totalWidth," ").concat(this.totalHeight)}},[this.genGradient(),this.genClipPath(t,e,this._lineWidth,"sparkline-bar-"+this._uid),this.hasLabels?this.genLabels(e):void 0,this.$createElement("g",{attrs:{"clip-path":"url(#sparkline-bar-".concat(this._uid,"-clip)"),fill:"url(#".concat(this._uid,")")}},[this.$createElement("rect",{attrs:{x:0,y:0,width:this.totalWidth,height:this.height}})])])}},genClipPath:function(t,e,a,i){var r=this,n="number"===typeof this.smooth?this.smooth:this.smooth?2:0;return this.$createElement("clipPath",{attrs:{id:"".concat(i,"-clip")}},t.map((function(t){return r.$createElement("rect",{attrs:{x:t.x+e,y:t.y,width:a,height:t.height,rx:n,ry:n}},[r.autoDraw?r.$createElement("animate",{attrs:{attributeName:"height",from:0,to:t.height,dur:"".concat(r.autoDrawDuration,"ms"),fill:"freeze"}}):void 0])})))},genTrend:function(){return this.$createElement("svg",this.setTextColor(this.color,{attrs:Object(l["a"])(Object(l["a"])({},this.$attrs),{},{display:"block","stroke-width":this._lineWidth||1,viewBox:"0 0 ".concat(this.width," ").concat(this.totalHeight)})}),[this.genGradient(),this.hasLabels&&this.genLabels(-this._lineWidth/2),this.genPath()])}},render:function(t){if(!(this.totalValues<2))return"trend"===this.type?this.genTrend():this.genBars()}}),L=Object(g["a"])(f,n,s,!1,null,null,null),V=L.exports;p()(L,{VCard:b["a"],VCardText:v["b"],VCardTitle:v["c"],VSparkline:z});var E={name:"Home",components:{DashboardComponent:V}},D=E,M=Object(g["a"])(D,i,r,!1,null,null,null);e["default"]=M.exports}}]);
//# sourceMappingURL=chunk-63af14aa.1f68b8c1.js.map