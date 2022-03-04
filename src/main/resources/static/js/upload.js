/*! formstone v1.4.22 [upload.js] 2021-10-01 | GPL-3.0 License | formstone.it */
!function(e){"function"==typeof define&&define.amd?define(["jquery","./core"],e):e(jQuery,Formstone)}(function(u,r){"use strict";function s(e,t,a){t.error=!0,e.$el.trigger($.fileError,[t,a]),e.aborting||v(e)}function a(e){e.disabled&&(this.removeClass(C.disabled),e.$input.prop("disabled",!1),e.disabled=!1)}function n(e){y.killEvent(e);var t=e.data;t.disabled||t.$input.trigger($.click)}function i(e){e.data.$el.addClass(C.focus)}function l(e){e.data.$el.removeClass(C.focus)}function o(e){y.killEvent(e);var t=e.data,a=t.$input[0].files;!t.disabled&&a.length&&g(t,a)}function c(e){y.killEvent(e),e.data.$el.addClass(C.dropping).trigger($.fileDragEnter)}function d(e){y.killEvent(e),e.data.$el.addClass(C.dropping).trigger($.fileDragOver)}function f(e){y.killEvent(e),e.data.$el.removeClass(C.dropping).trigger($.fileDragLeave)}function p(e){y.killEvent(e);var t=e.data,a=e.originalEvent.dataTransfer.files;t.$el.removeClass(C.dropping),t.disabled||g(t,a)}function g(e,t){var a=[],r=t.length;if(e.maxFiles){var n=e.maxFiles-e.uploaded;0<=n&&t.length>n&&(r=n)}if(0<r){for(var i=0;i<r;i++){var l={index:e.total++,file:t[i],name:t[i].name,size:t[i].size,started:!1,complete:!1,error:!1,transfer:null};a.push(l),e.queue.push(l)}e.$el.trigger($.queued,[a]),e.autoUpload&&h(e)}e.$input.val("")}function h(e){e.uploading||(S.on($.beforeUnload,function(){return e.leave}),e.uploading=!0,e.$el.trigger($.start,[e.queue])),v(e)}function v(e){var t=0,a=[];if(e.uploading){for(var r in e.queue)!e.queue.hasOwnProperty(r)||e.queue[r].complete||e.queue[r].error||a.push(e.queue[r]);for(var n in e.queue=a,e.queue)if(e.queue.hasOwnProperty(n)){if(e.queue[n].started||m(e,e.queue[n]),++t>=e.maxConcurrent)return;r++}0===t&&(S.off($.beforeUnload),e.uploading=!1,e.$el.trigger($.complete))}}function m(n,i){if(i.size>=n.maxSize||!0===i.error)s(n,i,"size");else if(n.chunked)i.started=!0,i.chunkSize=1024*n.chunkSize,i.totalChunks=Math.ceil(i.size/i.chunkSize),i.currentChunk=0,n.$el.trigger($.fileStart,[i]),function n(l,o){var e=o.chunkSize*o.currentChunk,t=e+o.chunkSize;t>o.size&&(t=o.size);var a=o.file[q](e,t),r=new FormData;r.append(l.postKey,a,o.file.name);r.append("chunks",o.totalChunks);r.append("chunk",o.currentChunk);r=k(l,r,o);!1===r?s(l,o,"abort"):o.chunkTransfer=u.ajax({url:l.action,data:r,dataType:l.dataType,headers:l.headers,type:"POST",contentType:!1,processData:!1,cache:!1,beforeSend:function(e,t){l.$el.trigger($.chunkStart,[o,t,e])},success:function(e,t,a){o.currentChunk++,l.$el.trigger($.chunkComplete,[o]);var r=Math.ceil(o.currentChunk/o.totalChunks*100);l.$el.trigger($.fileProgress,[o,r,t,a]),o.currentChunk<o.totalChunks?n(l,o):(o.complete=!0,l.$el.trigger($.fileComplete,[o,e,t,a]),v(l))},error:function(e,t,a){var r,n,i;n=o,i=a,(r=l).$el.trigger($.chunkError,[n,i]),s(r,n,i)}})}(n,i);else{var e=new FormData;e.append(n.postKey,i.file),!1===(e=k(n,e,i))?s(n,i,"abort"):(i.started=!0,i.transfer=u.ajax({url:n.action,data:e,dataType:n.dataType,headers:n.headers,type:"POST",contentType:!1,processData:!1,cache:!1,xhr:function(){var e=u.ajaxSettings.xhr();return e.upload&&e.upload.addEventListener("progress",function(e){var t=0,a=e.loaded||e.position,r=e.total;e.lengthComputable&&(t=Math.ceil(a/r*100)),n.$el.trigger($.fileProgress,[i,t,e])},!1),e},beforeSend:function(e,t){n.$el.trigger($.fileStart,[i,t,e])},success:function(e,t,a){i.complete=!0,n.uploaded++,n.$el.trigger($.fileComplete,[i,e,t,a]),v(n)},error:function(e,t,a){s(n,i,a)}}))}}function k(e,t,a){for(var r in e.postData)e.postData.hasOwnProperty(r)&&t.append(r,e.postData[r]);return t=e.beforeSend.call(e.$el,t,a)}var e=r.Plugin("upload",{widget:!0,defaults:{accept:!1,action:"",autoUpload:!0,beforeSend:function(e){return e},chunked:!1,chunkSize:100,customClass:"",dataType:"html",headers:{},label:"Drag and drop files or click to select",leave:"You have uploads pending, are you sure you want to leave this page?",maxConcurrent:2,maxFiles:!1,maxSize:5242880,multiple:!0,postData:{},postKey:"file",theme:"fs-light"},classes:["input","target","multiple","dropping","disabled","focus"],methods:{_construct:function(e){if(r.support.file){var t="";q||(e.chunked=!1),e.maxQueue&&(e.maxConcurrent=e.maxQueue),!1!==e.label&&(t+='<div class="'+C.target+'">',t+=e.label,t+="</div>"),t+='<input class="'+C.input+'" type="file"',e.multiple&&(t+=" multiple"),e.accept&&(t+=' accept="'+e.accept+'"'),t+=">",e.baseClasses=[C.base,e.theme,e.customClass].join(" "),this.addClass(e.baseClasses).append(t),e.$input=this.find(b.input),e.queue=[],e.total=0,e.uploaded=0,e.uploading=!1,e.disabled=!0,e.aborting=!1,this.on($.click,b.target,e,n).on($.dragEnter,e,c).on($.dragOver,e,d).on($.dragLeave,e,f).on($.drop,e,p),e.$input.on($.focus,e,i).on($.blur,e,l).on($.change,e,o),a.call(this,e)}},_destruct:function(e){r.support.file&&(e.$input.off($.namespace),this.off($.namespace).removeClass(e.baseClasses).html(""))},disable:function(e){e.disabled||(this.addClass(C.disabled),e.$input.prop("disabled",!0),e.disabled=!0)},enable:a,abort:function(e,t){var a;for(var r in e.aborting=!0,e.queue)e.queue.hasOwnProperty(r)&&(a=e.queue[r],(void 0===t||0<=t&&a.index===t)&&(a.started&&!a.complete?e.chunked?a.chunkTransfer.abort():a.transfer.abort():s(e,a,"abort")));e.aborting=!1,v(e)},start:h}}),b=e.classes,C=b.raw,$=e.events,y=e.functions,S=(r.window,r.$window),q=!1;r.Ready(function(){var e=["mozSlice","webkitSlice","slice"];if(r.support.file){var t=!1;try{t=new File([""],"f")}catch(e){}if(!t)try{t=new Blob([""],{})}catch(e){}if(t)for(var a in e)if(e.hasOwnProperty(a)&&e[a]in t){q=e[a];break}}}),$.chunkComplete="chunkcomplete",$.chunkError="chunkerror",$.chunkStart="chunkstart",$.complete="complete",$.fileComplete="filecomplete",$.fileDragEnter="filedragenter",$.fileDragLeave="filedragleave",$.fileDragOver="filedragover",$.fileError="fileerror",$.fileProgress="fileprogress",$.fileStart="filestart",$.start="start",$.queued="queued"});