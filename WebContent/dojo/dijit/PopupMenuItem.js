dojo.provide("dijit.PopupMenuItem");

dojo.require("dijit.MenuItem");

dojo.declare("dijit.PopupMenuItem",
		dijit.MenuItem,
		{
		_fillContent: function(){
			// summary: 
			//		When Menu is declared in markup, this code gets the menu label and
			//		the popup widget from the srcNodeRef.
			// description:
			//		srcNodeRefinnerHTML contains both the menu item text and a popup widget
			//		The first part holds the menu item text and the second part is the popup
			// example: 
			// |	<div dojoType="dijit.PopupMenuItem">
			// |		<span>pick me</span>
			// |		<popup> ... </popup>
			// |	</div>
			// tags:
			//		protected

			if(this.srcNodeRef){
				var nodes = dojo.query("*", this.srcNodeRef);
				dijit.PopupMenuItem.superclass._fillContent.call(this, nodes[0]);

				// save pointer to srcNode so we can grab the drop down widget after it's instantiated
				this.dropDownContainer = this.srcNodeRef;
			}
		},

		startup: function(){
			if(this._started){ return; }
			this.inherited(arguments);

			// we didn't copy the dropdown widget from the this.srcNodeRef, so it's in no-man's
			// land now.  move it to dojo.doc.body.
			if(!this.popup){
				var node = dojo.query("[widgetId]", this.dropDownContainer)[0];
				this.popup = dijit.byNode(node);
			}
			dojo.body().appendChild(this.popup.domNode);

			this.popup.domNode.style.display="none";
			if(this.arrowWrapper){
				dojo.style(this.arrowWrapper, "visibility", "");
			}
			dijit.setWaiState(this.focusNode, "haspopup", "true");
		},
		
		destroyDescendants: function(){
			if(this.popup){
				this.popup.destroyRecursive();
				delete this.popup;
			}
			this.inherited(arguments);
		}
	});

