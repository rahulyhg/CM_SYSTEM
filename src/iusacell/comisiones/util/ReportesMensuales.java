package iusacell.comisiones.util;

public class ReportesMensuales {
	
	/*public static String  ACTIVACIONES = 
		" select v.pc_desc_canal                                          NOMBRE_CANAL,		" +
		"        cv.pc_activ_mes                                          ACTIV_MES,		" +
		"        to_char(cv.cdg_region)                                   REGION,			" +
		"        pm.pc_desc_larga_plan                                    DESC_LARGA_PLAN,	" +
		"        to_char(cv.pc_cve_contrato)                              CVE_CONTRATO,		" +
		"        cv.pc_cuenta                                             CUENTA,			" +
		"        replace(ad.nombre_usua,'|','')||											" +
		"        replace(ad.pater_usua,'|','')||											" +
		"        replace(ad.mater_usua,'|','')                            CLIENTE,			" +
		"        cv.pc_esn                                                ESN,				" +
		"        to_char(ad.num_telefono)                                 NUM_TELEFONO,		" +
		"        to_char(cv.pc_fecha_venta,'dd-mm-yyyy')                  FECHA_VENTA,		" +
		"        to_char(ad.plazo_for)                                    PLAZO_FOR,		" +	
		"        '$' || trim(to_char(cv.pc_monto_activ,'99,999,990.00'))  MONTO_ACTIV,		" +
		"        SI.POBKPNOMBRE                                           POBLACION,		" +
		"        PC_DES_DIVISION                                          DIVISION,			" +
		"        SE.EDODENOMBRE                                           ESTADO,			" +
		"        ad.PC_MODELO                                             MODELO,			" +
		"        '$' || trim(to_char(cv.pc_renta,'99,999,990.00'))        RENTA,			" +
		"        to_char(cv.pc_porc_desc*100)                             PORC_DESCUENTO,	" +
		"        to_char(cv.PC_PORC_DESC_ADI *100)                        PORC_DESC_ADIC  	" +
		"  from prodcm.pc_comis_ventas  cv,         					" +
		"		prodcm.param_act ad,									" +
		"       prodcm.pc_paquetes_maestro pm,     						" +
		"       prodcm.sircestados se,              					" +
		"		prodcm.pc_divisiones d, 								" +
		"       prodcm.sirtseiseriesiusacell si,    					" +
		"		pc_canal v 												" + //--pc_canal@CLIECONP v
		"  where cv.pc_activ_mes = ?                                    " + // '201602'-- parametro del mes y año
		"    	and cv.cdg_cia           = ad.cdg_cia					" +
		"    	and cv.num_transaccion   = ad.num_transaccion			" +
		"    	and cv.tipo_transaccion  = ad.tipo_transaccion			" +
		"    	and cv.num_contrato      = ad.num_contrato				" +
		"    	and cv.cdg_region        = ad.cdg_region				" +
		"    	and cv.cdg_csi           = ad.cdg_csi					" +
		"    	and cv.PC_FECHA_VENTA    = ad.fec_transaccion			" +
		"    	and cv.pc_cve_paquete    = pm.pc_cve_paquete			" +
		"    	and SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6))	" +
		"    	and SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4))	" +
		"    	and SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4))	" +
		"    	and SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE 				" +
		"    	and D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION			" +
		"    	and v.pc_cve_canal       = cv.pc_cve_canal				"; */
	
	
	public static String  ACTIVACIONES =
	"SELECT v.pc_desc_canal NOMBRE_CANAL, "+        
    "cv.pc_activ_mes ACTIV_MES, "+        
    "to_char(cv.cdg_region) REGION, "+             
    "pm.pc_desc_larga_plan  DESC_LARGA_PLAN, "+     
    "to_char(cv.pc_cve_contrato) CVE_CONTRATO, "+        
    "cv.pc_cuenta  CUENTA, "+            
    "replace(ad.nombre_usua,'|','')|| "+                                            
    "replace(ad.pater_usua,'|','')|| "+                                            
    "replace(ad.mater_usua,'|','') CLIENTE, "+            
    "cv.pc_esn ESN, "+                
    "to_char(ad.num_telefono) NUM_TELEFONO, "+        
    "to_char(cv.pc_fecha_venta,'dd-mm-yyyy') FECHA_VENTA, "+        
    "to_char(ad.plazo_for) PLAZO_FOR, "+            
    "'$' || trim(to_char(cv.pc_monto_activ,'99,999,990.00'))  MONTO_ACTIV, "+        
    "SI.POBKPNOMBRE POBLACION, "+        
    "PC_DES_DIVISION DIVISION, "+            
    "SE.EDODENOMBRE  ESTADO, "+            
    "ad.PC_MODELO MODELO, "+            
    "'$' || trim(to_char(cv.pc_renta,'99,999,990.00')) RENTA, "+            
    "to_char(cv.pc_porc_desc*100) PORC_DESCUENTO, "+    
    "to_char(cv.PC_PORC_DESC_ADI *100) PORC_DESC_ADIC "+      
	"    FROM prodcm.pc_comis_ventas  cv, "+                             
   "prodcm.param_act ad, "+                                    
   "prodcm.pc_paquetes_maestro pm, "+                             
   "prodcm.sircestados se, "+                                  
   "prodcm.pc_divisiones d, "+                                 
   "prodcm.sirtseiseriesiusacell si, "+                        
   "pc_canal@ESISCOM_CYC v "+                                                 
	"    WHERE cv.pc_activ_mes = ? "+                                     
    "AND cv.cdg_cia           = ad.cdg_cia "+                    
    "AND cv.num_transaccion   = ad.num_transaccion "+            
    "AND cv.tipo_transaccion  = ad.tipo_transaccion "+            
    "AND cv.num_contrato      = ad.num_contrato "+                
    "AND cv.cdg_region        = ad.cdg_region "+                
    "AND cv.cdg_csi           = ad.cdg_csi "+                    
    "AND cv.PC_FECHA_VENTA    = ad.fec_transaccion "+            
    "AND cv.pc_cve_paquete    = pm.pc_cve_paquete "+            
    "AND SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6)) "+    
    "AND SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4)) "+    
    "AND SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4)) "+    
    "AND SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE "+                 
    "AND D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION "+            
    "AND v.pc_cve_canal       = cv.pc_cve_canal";
	
	
	
	/*public static String RENOVACIONES = 
		" select v.pc_desc_canal                               EMPRESARIO,				" +
		"        cr.pc_renova_mes                              PERIODO,					" +
		"        cr.cdg_region                                 REGION, 					" +
		"        pm.pc_desc_larga_plan                         DESCRIPCION_DEL_PLAN, 	" +
		"        to_char(cr.pc_fecha_renova, 'dd-mm-yyyy')     FECHA_RENOVACION,  		" +
		"        to_char(ad.fec_activacion,  'dd-mm-yyyy')     FECHA_ACTIVACION,		" +
		"        ad.plazo_for                                  PLAZO_FORZOSO, 			" +
		"        cr.pc_cuenta                                  CUENTA, 					" +
		"        to_char(cr.pc_cve_contrato)                   CONTRATO,				" +
		"        cr.pc_esn                                     ESN, 					" +
		"        ad.num_telefono                               TELEFONO, 				" +
		"        ad.nombre_usua||ad.pater_usua||ad.mater_usua  CLIENTE,        			" +
		"        to_char(cr.pc_porc_desc*100)                  DESCUENTO_MULTILINEA,	" +
		"        to_char(cr.PC_PORC_DESC_ADI *100)             DESCUENTO_ADICIONAL,		" +
		"        ad.PC_MODELO                                  MARCA,					" +
		"        '$' || trim(to_char(cr.pc_renta,'99,999,990.00'))         RENTA,		" +
		"        '$' || trim(to_char(cr.pc_monto_renova,'99,999,990.00'))  COMISION,	" +
		"        SI.POBKPNOMBRE                                POBLACION,				" +
		"        PC_DES_DIVISION                               DIVISION,				" +
		"        SE.EDODENOMBRE                                ESTADO					" +
		"   from prodcm.pc_comis_renovaciones cr,    								" +
		"		 prodcm.param_act ad,												" +
		"        prodcm.pc_paquetes_maestro pm,      								" +
		"        prodcm.sircestados se,              								" +
		"		 prodcm.pc_divisiones d, 											" +
		"        prodcm.sirtseiseriesiusacell si,    								" +
		"		pc_canal v 															" + //--pc_canal@CLIECONP v
		"  where cr.pc_renova_mes    = ?                                    		" + //'201602' -- parametro
		"    and cr.cdg_cia          = ad.cdg_cia 									" +
		"    and cr.num_transaccion  = ad.num_transaccion 							" +
		"    and cr.tipo_transaccion = ad.tipo_transaccion 							" +
		"    and cr.num_contrato     = ad.num_contrato 								" +
		"    and cr.cdg_region       = ad.cdg_region 								" +
		"    and cr.cdg_csi          = ad.cdg_csi 									" +
		"    and cr.PC_FECHA_renova   = ad.fec_transaccion							" +
		"    and ad.cdg_plan_uso     = pm.pc_cve_paquete 							" +
		"    and cr.pc_nivel         = (select pc_nivel_act 						" +
		"                                 from prodcm.pc_tot_renova 				" +
		"                                where pc_cve_canal  = cr.PC_CVE_CANAL		" +
		"                                  and pc_mes        = ?             		" + //'201602'-- parametro
		"                                  and rownum        = 1)					" +
		"    and cr.pc_cve_paquete    = pm.pc_cve_paquete							" +
		"    and SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6))		" +
		"    and SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4))		" +
		"    and SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4))		" +
		"    and SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE 								" +
		"    and D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION							" +
		"    and v.pc_cve_canal       = cr.pc_cve_canal								" +
		"  order by cr.PC_CVE_CANAL";
	    */ 
	
	public static String RENOVACIONES=
		"SELECT v.pc_desc_canal                               EMPRESARIO,					" +                 
        "cr.pc_renova_mes                              PERIODO,								" +                     
        "cr.cdg_region                                 REGION,              				" +     
        "pm.pc_desc_larga_plan                         DESCRIPCION_DEL_PLAN,  				" +      
        "to_char(cr.pc_fecha_renova, 'dd-mm-yyyy')     FECHA_RENOVACION,					" +           
        "to_char(ad.fec_activacion,  'dd-mm-yyyy')     FECHA_ACTIVACION,					" +         
        "ad.plazo_for                                  PLAZO_FORZOSO,						" +              
        "cr.pc_cuenta                                  CUENTA,								" +                      
        "to_char(cr.pc_cve_contrato)                   CONTRATO,							" +                 
        "cr.pc_esn                                     ESN,									" +                      
        "ad.num_telefono                               TELEFONO,							" +                  
        "ad.nombre_usua||ad.pater_usua||ad.mater_usua  CLIENTE,								" +                     
        "to_char(cr.pc_porc_desc*100)                  DESCUENTO_MULTILINEA,				" +     
        "to_char(cr.PC_PORC_DESC_ADI *100)             DESCUENTO_ADICIONAL,					" +         
        "ad.PC_MODELO                                  MARCA,								" +                     
        "'$' || trim(to_char(cr.pc_renta,'99,999,990.00'))         RENTA,					" +         
        "'$' || trim(to_char(cr.pc_monto_renova,'99,999,990.00'))  COMISION,     			" +
        "SI.POBKPNOMBRE                                POBLACION, 							" +                
        "PC_DES_DIVISION                               DIVISION, 							" +                
        "SE.EDODENOMBRE                                ESTADO 								" +                    
		"FROM prodcm.pc_comis_renovaciones cr, 												" +                                    
        "prodcm.param_act ad,             													" +                                    
        "prodcm.pc_paquetes_maestro pm,   													" +                                    
        "prodcm.sircestados se,      														" +                                         
        "prodcm.pc_divisiones d,    														" +                                          
        "prodcm.sirtseiseriesiusacell si,    												" +                                 
        "pc_canal@ESISCOM_CYC v            													" +                                                   
		"WHERE cr.pc_renova_mes    = ?            											" +                                
		"AND cr.cdg_cia          = ad.cdg_cia          										" +                            
		"AND cr.num_transaccion  = ad.num_transaccion              							" +                
		"AND cr.tipo_transaccion = ad.tipo_transaccion                      				" +        
		"AND cr.num_contrato     = ad.num_contrato            								" +                      
		"AND cr.cdg_region       = ad.cdg_region                							" +                  
		"AND cr.cdg_csi          = ad.cdg_csi             									" +                         
		"AND cr.PC_FECHA_renova   = ad.fec_transaccion           							" +                  
		"AND ad.cdg_plan_uso     = pm.pc_cve_paquete         								" +                     
		"AND cr.pc_nivel         = (SELECT pc_nivel_act        								" +                  
        "                         FROM prodcm.pc_tot_renova       							" +           
        "                        WHERE pc_cve_canal  = cr.PC_CVE_CANAL         				" +
        "                          AND pc_mes        = ?           							" +           
        "                          AND rownum        = 1)            						" +         
		"AND cr.pc_cve_paquete    = pm.pc_cve_paquete         								" +                    
		"AND SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6))    				" +     
		"AND SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4))       			" +  
		"AND SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4))    				" +     
		"AND SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE                           				" +       
		"AND D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION             							" +                
		"AND v.pc_cve_canal       = cr.pc_cve_canal               							" +                  
		"ORDER BY cr.PC_CVE_CANAL" ;		
	
	
	
	/*public static String CHARGE_BACK_POSPAGO = 
		"	select v.pc_desc_canal                          NOMBRE_CANAL,		" +
		"	       cb.pc_baja_mes                           BAJA_MES,			" +
		"	       cb.pc_esn                                ESN,				" +
		"	       cb.cdg_region                            REGION,				" +
		"	       pm.pc_desc_larga_plan                    DESC_LARGA_PLAN,	" +
		"	       cb.pc_cuenta                             CUENTA,				" +
		"	       to_char(cb.pc_cve_contrato)              CVE_CONTRATO,		" +
		"	       ad.num_telefono                          NUM_TELEFONO,		" +
		"	       to_char(cb.pc_fecha_venta, 'dd-mm-yyyy') FECHA_VENTA,		" +
		"	       to_char(cb.pc_fecha_baja,  'dd-mm-yyyy') FECHA_BAJA,			" +
		"	       '$' || trim(to_char(cb.pc_monto_act,   '99,999,990.00'))                   MONTO_ACT,	" +
		"	       '$' || trim(to_char(cb.pc_monto_resid, '99,999,990.00'))                   MONTO_RESID,	" +
		"	       '$' || trim(to_char(cb.pc_monto_act + cb.pc_monto_resid, '99,999,990.00')) COMISION,		" +
		"	       ad.plazo_for                                  PLAZO_FOR,		" +
		"	       to_char(cb.pc_fecha_baja - cb.pc_fecha_venta) DIAS,          " +
		"	       SI.POBKPNOMBRE                                POBLACION,		" +
		"	       PC_DES_DIVISION                               DIVISION,		" +
		"	       SE.EDODENOMBRE                                ESTADO,		" +
		"	       NVL(bb_razon_movimiento,'Baja')               RAZON_MOV,		" +
		"	       decode (cb.pc_origen_eqpo, 1, 'IUSACELL',2,'CAJON', cb.pc_origen_eqpo)     ORIGEN_EQUIP,	" +
		"	       trim(to_char(cb.PC_MONTO_EQPO, '$99,999,990.00'))                          MONTO_EQUIP	" +
		"	from prodcm.pc_comis_bajas cb,          								" +
		"		 prodcm.param_act ad, 												" +
		"	     prodcm.pc_paquetes_maestro pm,   									" +
		"	     prodcm.sircestados se,             								" +
		"		 prodcm.pc_divisiones d, 											" +
		"	     prodcm.sirtseiseriesiusacell si,   								" +
		"		 pc_canal  v, 														" + //--pc_canal  v
		"	     prodcm.bs_bajas_bscs b												" +
		"	where cb.pc_baja_mes            = ?                            			" + //'201602'-- parametro
		"	  and cb.pc_orig_baja           = 'AC'									" +
		"	  and cb.cdg_cia                = ad.cdg_cia							" +
		"	  and cb.num_transaccion        = ad.num_transaccion					" +
		"	  and cb.tipo_transaccion       = ad.tipo_transaccion					" +
		"	  and cb.num_contrato           = ad.num_contrato						" +
		"	  and cb.cdg_region             = ad.cdg_region							" +
		"	  and cb.cdg_csi                = ad.cdg_csi							" +
		"	  and ad.cdg_plan_uso           = pm.pc_cve_paquete						" +
		"	  and SI.SERIE (+)              = to_number(substr(ad.num_telefono,1,6))" +
		"	  and SI.RANGO_INI (+)         <= to_number(substr(ad.num_telefono,7,4))" +
		"	  and SI.RANGO_FIN (+)         >= to_number(substr(ad.num_telefono,7,4))" +
		"	  and SE.EDOCLCLAVE (+)         = SI.EDOCLCLAVE 						" +
		"	  and D.PC_CVE_DIVISION (+)     = SI.PC_CVE_DIVISION					" +
		"	  and v.pc_cve_canal            = cb.pc_cve_canal						" +
		"	  and cb.pc_cve_contrato        = b.bb_cve_contrato (+)					"; */
	
	
	public static String CHARGE_BACK_POSPAGO =
		"SELECT v.pc_desc_canal                          NOMBRE_CANAL,    	" +      
        "cb.pc_baja_mes                           BAJA_MES,             	" + 
        "cb.pc_esn                                ESN,                  	" +
        "cb.cdg_region                            REGION,                  	" +
        "pm.pc_desc_larga_plan                    DESC_LARGA_PLAN,      	" +
        "cb.pc_cuenta                             CUENTA,                  	" +
        "to_char(cb.pc_cve_contrato)              CVE_CONTRATO,          	" +
        "ad.num_telefono                          NUM_TELEFONO,          	" +
        "to_char(cb.pc_fecha_venta, 'dd-mm-yyyy') FECHA_VENTA,          	" +
        "to_char(cb.pc_fecha_baja,  'dd-mm-yyyy') FECHA_BAJA,              	" +
        "'$' || trim(to_char(cb.pc_monto_act,   '99,999,990.00'))                   MONTO_ACT,		" +      
        "'$' || trim(to_char(cb.pc_monto_resid, '99,999,990.00'))                   MONTO_RESID,	" +      
        "'$' || trim(to_char(cb.pc_monto_act + cb.pc_monto_resid, '99,999,990.00')) COMISION, 		" +         
        "ad.plazo_for                                  PLAZO_FOR,			" +          
        "to_char(cb.pc_fecha_baja - cb.pc_fecha_venta) DIAS,            	" +
        "SI.POBKPNOMBRE                                POBLACION,          	" +
        "PC_DES_DIVISION                               DIVISION,          	" +
        "SE.EDODENOMBRE                                ESTADO,          	" +
        "NVL(bb_razon_movimiento,'Baja')               RAZON_MOV,          	" +
        "decode (cb.pc_origen_eqpo, 1, 'IUSACELL',2,'CAJON', cb.pc_origen_eqpo)     ORIGEN_EQUIP, 	" +     
        "trim(to_char(cb.PC_MONTO_EQPO, '$99,999,990.00'))                          MONTO_EQUIP		" +      
		"FROM prodcm.pc_comis_bajas cb,                                            					" +
		"prodcm.param_act ad,                                                   					" +
		"prodcm.pc_paquetes_maestro pm,                                         					" +
		"prodcm.sircestados se,                                               						" +
		"prodcm.pc_divisiones d,                                               						" +
		"prodcm.sirtseiseriesiusacell si,                                     						" +
		"pc_canal@ESISCOM_CYC v ,                                                      				" +
		"prodcm.bs_bajas_bscs b                                                  					" +
		"WHERE cb.pc_baja_mes            = ?                                          				" +
		"AND cb.pc_orig_baja           = 'AC'                                      					" +
		"AND cb.cdg_cia                = ad.cdg_cia                              					" +
		"AND cb.num_transaccion        = ad.num_transaccion                      					" +
		"AND cb.tipo_transaccion       = ad.tipo_transaccion                      					" +
		"AND cb.num_contrato           = ad.num_contrato                          					" +
		"AND cb.cdg_region             = ad.cdg_region                              				" +
		"AND cb.cdg_csi                = ad.cdg_csi                              					" +
		"AND ad.cdg_plan_uso           = pm.pc_cve_paquete                          				" +
		"AND SI.SERIE (+)              = to_number(substr(ad.num_telefono,1,6))  					" +
		"AND SI.RANGO_INI (+)         <= to_number(substr(ad.num_telefono,7,4))  					" +
		"AND SI.RANGO_FIN (+)         >= to_number(substr(ad.num_telefono,7,4))  					" +
		"AND SE.EDOCLCLAVE (+)         = SI.EDOCLCLAVE                           					" +
		"AND D.PC_CVE_DIVISION (+)     = SI.PC_CVE_DIVISION                      					" +
		"AND v.pc_cve_canal            = cb.pc_cve_canal                          					" +
		"AND cb.pc_cve_contrato        = b.bb_cve_contrato (+)";  
	   

	/*public static String CHARGE_BACK_RENOV_POSPAGO = 
		"	select v.pc_desc_canal                          NOMBRE_CANAL,								" +
		"	       cb.pc_baja_mes                           BAJA_MES,									" +
		"	       cb.pc_esn                                ESN,										" +
		"	       cb.cdg_region                            REGION,										" +
		"	       pm.pc_desc_larga_plan                    DESC_LARGA_PLAN,							" +
		"	       cb.pc_cuenta                             CUENTA,										" +
		"	       to_char(cb.pc_cve_contrato)              CVE_CONTRATO,								" +
		"	       ad.num_telefono                          NUM_TELEFONO,								" +
		"	       to_char(cb.pc_fecha_venta, 'dd-mm-yyyy') FECHA_VENTA,								" +
		"	       to_char(cb.pc_fecha_baja,  'dd-mm-yyyy') FECHA_BAJA,									" +
		"	       '$' || trim(to_char(cb.pc_monto_act, '99,999,990.00')) COMISION,						" +
		"	       cb.pc_monto_serv                               MONTO_SERV,							" +
		"	       to_char(trunc(pc_fecha_baja - pc_fecha_venta)) DIAS,									" +
		"	       SI.POBKPNOMBRE                                 POBLACION,							" +
		"	       PC_DES_DIVISION                                DIVISION,								" +
		"	       SE.EDODENOMBRE                                 ESTADO,								" +
		"	       NVL(bb_razon_movimiento,cb.pc_razon_mov)       RAZON_MOV,							" +
		"	       decode (cb.pc_origen_eqpo, 1, 'IUSACELL',2,'CAJON', cb.pc_origen_eqpo) ORIGEN_EQPO,	" +
		"	       trim(to_char(cb.PC_MONTO_EQPO, '$99,999,990.00'))                      MONTO_EQPO	" +
		"	 from  prodcm.pc_comis_bajas cb,        								" +
		"	       prodcm.param_act ad, 											" +
		"	       prodcm.pc_paquetes_maestro pm,   								" +
		"		   pc_canal  v, 														" + //--pc_canal  v
		"	       prodcm.sircestados se,           								" +
		"	       prodcm.pc_divisiones d, 											" +
		"	       prodcm.sirtseiseriesiusacell si, 								" +
		"	       prodcm.bs_bajas_bscs b											" +
		"	 where cb.pc_baja_mes       = ?                   						" + // '201602'-- parametro
		"	   and pc_orig_baja         = 'RE'										" +
		"	   and v.pc_cve_canal       = cb.pc_cve_canal							" +
		"	   and cb.cdg_cia           = ad.cdg_cia								" +
		"	   and cb.num_transaccion   = ad.num_transaccion						" +
		"	   and cb.tipo_transaccion  = ad.tipo_transaccion						" +
		"	   and cb.num_contrato      = ad.num_contrato							" +
		"	   and cb.cdg_region        = ad.cdg_region								" +
		"	   and cb.cdg_csi           = ad.cdg_csi								" +
		"	   and ad.cdg_plan_uso      = pm.pc_cve_paquete							" +
		"	   and SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6))	" +
		"	   and SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4))	" +
		"	   and SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4))	" +
		"	   and SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE 							" +
		"	   and D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION						" +
		"	   and cb.pc_cve_contrato   = b.bb_cve_contrato (+)						" ; */
	
	public static String CHARGE_BACK_RENOV_POSPAGO = 
		 "SELECT v.pc_desc_canal                          NOMBRE_CANAL, 	" +                                 
         "cb.pc_baja_mes                           BAJA_MES,            	" +                          
         "cb.pc_esn                                ESN,              	    " +                            
         "cb.cdg_region                            REGION,             		" +                             
         "pm.pc_desc_larga_plan                    DESC_LARGA_PLAN,      	" +                        
         "cb.pc_cuenta                             CUENTA,             		" +                             
         "to_char(cb.pc_cve_contrato)              CVE_CONTRATO,        	" +                          
         "ad.num_telefono                          NUM_TELEFONO,       		" +                           
         "to_char(cb.pc_fecha_venta, 'dd-mm-yyyy') FECHA_VENTA,        		" +                          
         "to_char(cb.pc_fecha_baja,  'dd-mm-yyyy') FECHA_BAJA,       		" +                               
         "'$' || trim(to_char(cb.pc_monto_act, '99,999,990.00')) COMISION,  	" +                        
         "cb.pc_monto_serv                               MONTO_SERV,           	" +                 
         "to_char(trunc(pc_fecha_baja - pc_fecha_venta)) DIAS,                 	" +                     
         "SI.POBKPNOMBRE                                 POBLACION,         	" +                     
         "PC_DES_DIVISION                                DIVISION,         		" +                         
         "SE.EDODENOMBRE                                 ESTADO,             	" +                     
         "NVL(bb_razon_movimiento,cb.pc_razon_mov)       RAZON_MOV,            	" +                  
         "decode (cb.pc_origen_eqpo, 1, 'IUSACELL',2,'CAJON', cb.pc_origen_eqpo) ORIGEN_EQPO,  		" +    
         "trim(to_char(cb.PC_MONTO_EQPO, '$99,999,990.00'))                      MONTO_EQPO      	" +
		 "FROM  prodcm.pc_comis_bajas cb,                             		" +             
         "prodcm.param_act ad,                                        		" +       
         "prodcm.pc_paquetes_maestro pm,                                	" +     
         "pc_canal@ESISCOM_CYC v,                                       	" +                    
         "prodcm.sircestados se,                                          	" +   
         "prodcm.pc_divisiones d,                                         	" +      
         "prodcm.sirtseiseriesiusacell si,                                	" +   
         "prodcm.bs_bajas_bscs b                                      		" +        
		 "WHERE cb.pc_baja_mes       = ?                             		" +               
		 "AND pc_orig_baja         = 'RE'                             		" +             
		 "AND v.pc_cve_canal       = cb.pc_cve_canal                		" +              
		 "AND cb.cdg_cia           = ad.cdg_cia                       		" +           
		 "AND cb.num_transaccion   = ad.num_transaccion                		" +          
		 "AND cb.tipo_transaccion  = ad.tipo_transaccion              		" +            
		 "AND cb.num_contrato      = ad.num_contrato                		" +              
		 "AND cb.cdg_region        = ad.cdg_region                   		" +               
		 "AND cb.cdg_csi           = ad.cdg_csi                        		" +          
		 "AND ad.cdg_plan_uso      = pm.pc_cve_paquete                		" +              
		 "AND SI.SERIE (+)         = to_number(substr(ad.num_telefono,1,6)) " +     
		 "AND SI.RANGO_INI (+)    <= to_number(substr(ad.num_telefono,7,4)) " +     
         "AND SI.RANGO_FIN (+)    >= to_number(substr(ad.num_telefono,7,4)) " +     
		 "AND SE.EDOCLCLAVE (+)    = SI.EDOCLCLAVE                       	" +        
		"AND D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION                  	" +        
		"AND cb.pc_cve_contrato   = b.bb_cve_contrato (+)";

	/* Not used anymore
	 * public static String COM_DIFERIDA_ACTIVACIONES_KYH = 
		"	select cob.pc_cve_contrato    										 CVE_CONTRATO_ACT,	" +
		"	       TRIM (TO_CHAR (nvl(cob.PC_RENTA,0),        '$99,999,990.00')) RENTA_ACT,			" +
		"	       TRIM (TO_CHAR (nvl(cob.PC_PORC_DESC,0),    '$99,999,990.00')) PORC_DESC,			" +
		"	       TRIM (TO_CHAR (nvl(cob.PC_PORC_DESC_ADI,0),'$99,999,990.00')) PORC_DESC_ADI,	" +
		"	       cob.PC_CVE_CANAL             CVE_CANAL,			" +
		"	       cob.PC_CVE_ESQUEMA           CVE_ESQUEMA,		" +
		"	       cob.PC_PLZ_FOR               PLZ_FOR,			" +
		"	       param.ESN                    ESN,				" +
		"	       param.NUM_TELEFONO           NUM_TELEFONO,		" +
		"	       '' || hijo.PC_NUM_PAGO       NUM_PAGO_STR,		" +
		"	       '' || hijo.PC_CVE_COBRANZA   CVE_COBRANZA,		" +
		"	       hijo.PC_ORIGEN               ORIGEN,				" +
		"	       to_char(hijo.PC_FECHA_VENTA,'dd/mm/yyyy')                    FECHA_VENTA,	" +
		"	       TRIM (TO_CHAR (nvl(hijo.PC_COMISION,0), '$99,999,990.00'))   COMISION		" +
		"	 from prodcm.PRODCM_CONTRATOS_COBRANZA cob								" +
		"	     ,prodcm.PC_COMIS_COBRANZA_VTA     hijo								" +
		"	     ,prodcm.param_act          param									" +
		"	where param.CDG_CSI          = cob.CDG_CSI								" +
		"	  and param.CDG_REGION       = cob.CDG_REGION							" +
		"	  and param.NUM_CONTRATO     = cob.NUM_CONTRATO							" +
		"	  and param.TIPO_TRANSACCION = cob.TIPO_TRANSACCION						" +
		"	  and param.NUM_TRANSACCION  = cob.NUM_TRANSACCION						" +
		"	  and param.CDG_CIA          = cob.CDG_CIA								" +
		"	  and cob.CDG_CSI            = hijo.CDG_CSI								" +
		"	  and cob.CDG_REGION         = hijo.CDG_REGION							" +
		"	  and cob.NUM_CONTRATO       = hijo.NUM_CONTRATO						" +
		"	  and cob.TIPO_TRANSACCION   = hijo.TIPO_TRANSACCION					" +
		"	  and cob.NUM_TRANSACCION    = hijo.NUM_TRANSACCION						" +
		"	  and cob.CDG_CIA            = hijo.CDG_CIA								" +
		"	  and cob.pc_origen          = 'ACT'									" +
		"	  AND cob.PC_CVE_GPO         = 1										" +
		"	  and hijo.pc_origen         = 'ACT'									" +
		"	  and hijo.PC_CVE_CONTRATO   = cob.pc_cve_contrato						" +
		"	  and PC_MES = ? 	" ;														//--'200911' */
	
	/* Not used anymore
	 * public static String COM_DIFERIDA_RENOVACIONES_KYH = 
		"	select  cob.pc_cve_contrato          								   CVE_CONTRATO_ACT	" +
		"	        ,TRIM (TO_CHAR (nvl(cob.PC_RENTA,0),        '$99,999,990.00')) RENTA_ACT		" +
		"	        ,TRIM (TO_CHAR (nvl(cob.PC_PORC_DESC,0),    '$99,999,990.00')) PORC_DESC		" +
		"	        ,TRIM (TO_CHAR (nvl(cob.PC_PORC_DESC_ADI,0),'$99,999,990.00')) PORC_DESC_ADI	" +
		"	        ,cob.PC_CVE_CANAL             CVE_CANAL											" +
		"	        ,cob.PC_CVE_ESQUEMA           CVE_ESQUEMA										" +
		"	        ,cob.PC_PLZ_FOR               PLZ_FOR											" +
		"	        ,param.ESN                    ESN												" +
		"	        ,param.NUM_TELEFONO           NUM_TELEFONO										" +
		"	        ,'' || hijo.PC_NUM_PAGO       NUM_PAGO_STR										" +
		"	        ,'' || hijo.PC_CVE_COBRANZA   CVE_COBRANZA										" +
		"	        ,hijo.PC_ORIGEN               ORIGEN											" +
		"	        ,to_char(hijo.PC_FECHA_RENOVA,'dd/mm/yyyy')                   FECHA_VENTA		" +
		"	        ,TRIM (TO_CHAR (nvl(hijo.PC_COMISION,0), '$99,999,990.00'))   COMISION			" +
		"	    from prodcm.PRODCM_CONTRATOS_COBRANZA  cob							" +
		"	        ,prodcm.PC_COMIS_COBRANZA_REN      hijo							" +
		"	        ,prodcm.param_act           param								" +
		"	   where param.CDG_CSI          =   cob.CDG_CSI							" +
		"	     and param.CDG_REGION       =   cob.CDG_REGION						" +
		"	     and param.NUM_CONTRATO     =   cob.NUM_CONTRATO					" +
		"	     and param.TIPO_TRANSACCION =   cob.TIPO_TRANSACCION				" +
		"	     and param.NUM_TRANSACCION  =   cob.NUM_TRANSACCION					" +
		"	     and param.CDG_CIA          =   cob.CDG_CIA							" +
		"	     and cob.CDG_CSI            =   hijo.CDG_CSI						" +
		"	     and cob.CDG_REGION         =   hijo.CDG_REGION						" +
		"	     and cob.NUM_CONTRATO       =   hijo.NUM_CONTRATO					" +
		"	     and cob.TIPO_TRANSACCION   =   hijo.TIPO_TRANSACCION				" +
		"	     and cob.NUM_TRANSACCION    =   hijo.NUM_TRANSACCION				" +
		"	     and cob.CDG_CIA            =   hijo.CDG_CIA						" +
		"	     and cob.pc_origen          =   'REN'								" +
		"	     and hijo.pc_origen         =   'REN'								" +
		"	     and hijo.PC_CVE_CONTRATO   =   cob.pc_cve_contrato     			" +
		"	     and PC_MES                 =   ?							" ;	// --'201602'*/
	
	/*public static String DESCUENTOS_MULTILINEA =
		"	 select b.CDG_VENDEDOR      	VENDEDOR,			" +
		"			c.PC_DESC_CANAL     	DESC_CANAL,			" +
		"	   		a.NUM_CONTRATO			NUM_CONTRATO,		" +
		"	   		SUBSTR(descuento_multilinea,LENGTH(descuento_multilinea)-1 ,2)/100 PORC_DESC      	  " +
		"	  FROM 	PRODCM.PARAM_ACT A, 											" +
		"			PRODCM.TRANSACCION_MTRO B , 									" +
		"			pvc.pvc_linea_cuenta@ESISCOM_PORTREP d,							" +
		"		 	pc_canal  c 														" + //--pc_canal  v
		"	  WHERE A.CDG_CIA = B.CDG_CIA      										" +
		"	    AND A.NUM_TRANSACCION  = B.NUM_TRANSACCION							" +
		"	    AND A.TIPO_TRANSACCION = B.TIPO_TRANSACCION 						" +
		"	    AND A.CDG_REGION       = B.CDG_REGION 								" +
		"	    AND A.CDG_CSI = B.CDG_CSI											" +
		"	    AND A.FEC_TRANSACCION   =  B.FEC_TRANSACCION						" +
		"	    AND TO_CHAR(B.fec_transaccion,'yyyymm') = ?							" + //'201602'-- parametro
		"	    AND d.fecha_aprovisionamiento >= ADD_MONTHS(LAST_DAY(add_months(TO_DATE(? || '000000', 'RRRRMMDD HH24MISS'),-1)),-1)+1 	" + //'20160201' -- parametro 1ero del mes 
		"	    AND d.fecha_aprovisionamiento <= TO_DATE(? || '235959', 'RRRRMMDD HH24MISS') " + //'20160229' --- parametro último de mes 
		"	    AND d.codigo_error_contrato IN  (7,-7)								" +
		"	    AND a.CVE_CONTRATO   =  id_contrato									" +
		"	    and b.CDG_VENDEDOR = c.pc_cve_canal(+)								" ; */
	
	
	public static String DESCUENTOS_MULTILINEA =
	"SELECT b.CDG_VENDEDOR          VENDEDOR,     	" +         
    "    c.PC_DESC_CANAL         DESC_CANAL,      	" +         
    "    a.NUM_CONTRATO            NUM_CONTRATO,  	" +        
    "       SUBSTR(descuento_multilinea,LENGTH(descuento_multilinea)-1 ,2)/100 PORC_DESC   " +           
	"FROM     PRODCM.PARAM_ACT A,              	  	" +                                 
    "   PRODCM.TRANSACCION_MTRO B ,            		" +                           
    "   pvc.pvc_linea_cuenta@ESISCOM_PORTAL d,     	" +                         
    "     pc_canal@ESISCOM_CYC c                  	" +                                         
	"WHERE A.CDG_CIA = B.CDG_CIA                    " +                            
    "AND A.NUM_TRANSACCION  = B.NUM_TRANSACCION     " +                         
    "AND A.TIPO_TRANSACCION = B.TIPO_TRANSACCION    " +                       
    "AND A.CDG_REGION       = B.CDG_REGION          " +                         
    "AND A.CDG_CSI = B.CDG_CSI                    	" +                          
    "AND A.FEC_TRANSACCION   =  B.FEC_TRANSACCION   " +                       
    "AND TO_CHAR(B.fec_transaccion,'yyyymm') = ?   	" +                            
    "AND d.fecha_aprovisionamiento >= ADD_MONTHS(LAST_DAY(add_months(TO_DATE( ? || '000000', 'RRRRMMDD HH24MISS'),-1)),-1)+1   " +     
    "AND d.fecha_aprovisionamiento <= TO_DATE( ? || '235959', 'RRRRMMDD HH24MISS')    										   " +
    "AND d.codigo_error_contrato IN  (7,-7)         " +                         
    "AND a.CVE_CONTRATO   =  id_contrato            " +                           
    "AND b.CDG_VENDEDOR = c.pc_cve_canal(+)" ;

	/*public static String DESCUENTOS_ADICIONAL =
		"	SELECT 	b.CDG_VENDEDOR		VENDEDOR,      							" +
		"			c.PC_DESC_CANAL		DESC_CANAL,     						" +
		"	        A.cve_contrato      CONTRATO,								" +
		"	        (PPS.penalizacion_vendedores / 100)   DESCTO				" +
		"	   FROM   PVC_PROPUESTA_SERVICIOS@ESISCOM_PORTREP  PPS,				" +
		"	          PVC_LINEA_CUENTA@ESISCOM_PORTREP         PLC,				" +
		"	          prodcm.PARAM_ACT                         A,				" +
		"	          prodcm.TRANSACCION_MTRO                  B,				" +
		"		 	  pc_canal  c 												" + //--pc_canal  v
		"	   WHERE  PLC.id_propuesta_servicios = PPS.id						" +
		"	   AND    A.cdg_cia          = B.cdg_cia							" +
		"	   AND    A.num_transaccion  = B.num_transaccion					" +
		"	   AND    A.tipo_transaccion = B.tipo_transaccion					" +
		"	   AND    A.cdg_region       = B.cdg_region							" +
		"	   AND    A.cdg_csi          = B.cdg_csi							" +
		"	   AND 	  A.FEC_TRANSACCION   =  B.FEC_TRANSACCION					" +
		"	   AND    PLC.id_contrato    = A.cve_contrato						" +
		"	   AND    PLC.fecha_aprovisionamiento >= ADD_MONTHS(LAST_DAY(add_months(TO_DATE(? || '000000', 'RRRRMMDD HH24MISS'),-1)),-1)+1	" + //'20160201' -- parametro 1ero del mes
		"	   AND    PLC.fecha_aprovisionamiento <= TO_DATE(?, 'RRRRMMDD') + 0.99999	" + //'20160229'-- parametro último de mes 
		"	   AND    TO_CHAR(B.fec_transaccion,'yyyymm') = ?					" + //'201602'-- parametro 
		"	   AND    PPS.penalizacion_vendedores IS NOT NULL					" +
		"	   AND    PPS.id_tipo_referencia IN ('RN', 'CL','PR' ) 				" +
		"	   and    b.CDG_VENDEDOR = c.pc_cve_canal(+)						" +
		"	   AND    PPS.penalizacion_vendedores > 0							" ; */
	
	
	
	public static String DESCUENTOS_ADICIONAL =
		 "SELECT     b.CDG_VENDEDOR        VENDEDOR,     	" +                               
         "c.PC_DESC_CANAL        DESC_CANAL,             	" +                  
         "A.cve_contrato      CONTRATO,                   	" +               
         "(PPS.penalizacion_vendedores / 100)   DESCTO    	" +              
		 "FROM   PVC_PROPUESTA_SERVICIOS@ESISCOM_PORTAL  PPS, 	" +                 
         "PVC_LINEA_CUENTA@ESISCOM_PORTAL         PLC,   	" +               
         "prodcm.PARAM_ACT                         A,     	" +             
         "prodcm.TRANSACCION_MTRO                  B,      	" +           
         "  pc_canal@ESISCOM_CYC c                         	" +                           
		 "WHERE  PLC.id_propuesta_servicios = PPS.id      	" +                    
		 "AND    A.cdg_cia          = B.cdg_cia          	" +                    
		 "AND    A.num_transaccion  = B.num_transaccion    	" +                  
		 "AND    A.tipo_transaccion = B.tipo_transaccion   	" +                   
		 "AND    A.cdg_region       = B.cdg_region        	" +                      
		 "AND    A.cdg_csi          = B.cdg_csi           	" +                   
		 "AND       A.FEC_TRANSACCION   =  B.FEC_TRANSACCION 	" +                      
		 "AND    PLC.id_contrato    = A.cve_contrato       	" +                   
         "AND    PLC.fecha_aprovisionamiento >= ADD_MONTHS(LAST_DAY(add_months(TO_DATE( ? || '000000', 'RRRRMMDD HH24MISS'),-1)),-1)+1  	" +     
         "AND    PLC.fecha_aprovisionamiento <= TO_DATE( ? , 'RRRRMMDD') + 0.99999   	" +    
		 "AND    TO_CHAR(B.fec_transaccion,'yyyymm') = ?	" +                       
         "AND    PPS.penalizacion_vendedores IS NOT NULL  	" +                    
		 "AND    PPS.id_tipo_referencia IN ('RN', 'CL','PR' ) 	" +                   
		 "AND    b.CDG_VENDEDOR = c.pc_cve_canal(+)      	" +                    
		 "AND    PPS.penalizacion_vendedores > 0";
	
	/*public static String DCTOS_MULTILINEA_TOTALES =
		"	SELECT  id_contrato                       CVE_CONTRATO,				" +
		"	        trunc(fecha_aprovisionamiento)    FEC_DESC,					" +
		"	        SUBSTR(descuento_multilinea,LENGTH(descuento_multilinea)-1 ,2) PORC_DESC," +
		"	        DESCRIPCION_PLAN_SERVICIO,									" +
		"			RENTA_FIJA													" +
		"	    FROM  pvc.pvc_linea_cuenta@ESISCOM_PORTREP 						" +
		"	    WHERE fecha_aprovisionamiento >= TO_DATE(? || '235959', 'RRRRMMDD HH24MISS') 	" + //'20160201' -- parametro 1ero del mes
		"	      AND fecha_aprovisionamiento <= TO_DATE(? || '235959', 'RRRRMMDD HH24MISS')	" + //'20160229'  -- parametro último de mes 
		"	      AND codigo_error_contrato IN  (7,-7)     							" +
		"	      AND (INSTR(descuento_multilinea,0) > 0 OR							" +
		"	           INSTR(descuento_multilinea,1) > 0 OR							" +
		"	           INSTR(descuento_multilinea,2) > 0 OR							" +
		"	           INSTR(descuento_multilinea,3) > 0 OR							" +
		"	           INSTR(descuento_multilinea,4) > 0 OR							" +
		"	           INSTR(descuento_multilinea,5) > 0 OR							" +
		"	           INSTR(descuento_multilinea,6) > 0 OR							" +
		"	           INSTR(descuento_multilinea,7) > 0 OR							" +
		"	           INSTR(descuento_multilinea,8) > 0 OR   			           	" +
		"	           INSTR(descuento_multilinea,9) > 0)							" ; */
	
	
	public static String DCTOS_MULTILINEA_TOTALES =
		 "SELECT  id_contrato                       CVE_CONTRATO, "+                  
        "trunc(fecha_aprovisionamiento)    FEC_DESC, "+                      
        "SUBSTR(descuento_multilinea,LENGTH(descuento_multilinea)-1 ,2) PORC_DESC, "+  
        "DESCRIPCION_PLAN_SERVICIO, "+                                      
        "RENTA_FIJA "+                                                      
		 "  FROM  pvc.pvc_linea_cuenta@ESISCOM_PORTAL "+                        
		"  WHERE fecha_aprovisionamiento >= TO_DATE( ? || '235959', 'RRRRMMDD HH24MISS') "+        
      "AND fecha_aprovisionamiento <= TO_DATE( ? || '235959', 'RRRRMMDD HH24MISS') "+       
      "AND codigo_error_contrato IN  (7,-7) "+                                   
      "AND (INSTR(descuento_multilinea,0) > 0 OR "+                              
      "    INSTR(descuento_multilinea,1) > 0 OR "+                              
      "     INSTR(descuento_multilinea,2) > 0 OR "+                              
      "     INSTR(descuento_multilinea,3) > 0 OR "+                              
      "    INSTR(descuento_multilinea,4) > 0 OR "+                              
      "     INSTR(descuento_multilinea,5) > 0 OR "+                              
      "     INSTR(descuento_multilinea,6) > 0 OR "+                              
      "     INSTR(descuento_multilinea,7) > 0 OR "+                              
      "     INSTR(descuento_multilinea,8) > 0 OR "+                                
      "    INSTR(descuento_multilinea,9) > 0)";

	/*public static String DCTOS_ADICIONAL_TOTALES =
		"	SELECT    PLC.id_contrato                       CONTRATO,				" +
		"	          trunc(PLC.fecha_aprovisionamiento)    FEC_DESC, 				" +
		"	          (PPS.penalizacion_vendedores / 100)   DESC_ADI,     		 	" +
		"	          DESCRIPCION_PLAN_SERVICIO,									" +
		"			  RENTA_FIJA                          							" +
		"	   FROM   PVC_PROPUESTA_SERVICIOS@ESISCOM_PORTREP  PPS,					" +
		"	          PVC_LINEA_CUENTA@ESISCOM_PORTREP         PLC         			" +
		"	   WHERE  PLC.id_propuesta_servicios = PPS.id							" +
		"	     AND  trunc(PLC.fecha_aprovisionamiento) >= TO_DATE(?, 'RRRRMMDD')	" + //'20160201'   -- parametro 1ero del mes
		"	     AND  trunc(PLC.fecha_aprovisionamiento) <= TO_DATE(?, 'RRRRMMDD')	" + //'20160229'   -- parametro último de mes 
		"	     AND  PPS.penalizacion_vendedores IS NOT NULL						" +
		"	     AND  PPS.id_tipo_referencia IN ('RN', 'CL','PR' ) 					" +
		"	     AND  PPS.penalizacion_vendedores > 0								" ;*/
	
	public static String DCTOS_ADICIONAL_TOTALES =
		 "SELECT    PLC.id_contrato                       CONTRATO, "+                  
         "trunc(PLC.fecha_aprovisionamiento)    FEC_DESC, "+                   
         "(PPS.penalizacion_vendedores / 100)   DESC_ADI, "+                    
         "DESCRIPCION_PLAN_SERVICIO, "+                                      
         "RENTA_FIJA "+                                                        
         " FROM   PVC_PROPUESTA_SERVICIOS@ESISCOM_PORTAL  PPS, "+                      
         "PVC_LINEA_CUENTA@ESISCOM_PORTAL         PLC "+                       
         " WHERE  PLC.id_propuesta_servicios = PPS.id "+                              
         "AND  trunc(PLC.fecha_aprovisionamiento) >= TO_DATE(?, 'RRRRMMDD') "+       
         "AND  trunc(PLC.fecha_aprovisionamiento) <= TO_DATE(?, 'RRRRMMDD') "+        
         "AND  PPS.penalizacion_vendedores IS NOT NULL "+                          
         "AND  PPS.id_tipo_referencia IN ('RN', 'CL','PR' ) "+                       
         "AND  PPS.penalizacion_vendedores > 0";
	
	
	/*public static String PREPAGO_EQ_NUEVO =
		"	select v.pc_desc_canal                      NOMBRE						" +
		"	       ,cp.pc_activ_mes                     ACTIV_MEX					" +
		"	       ,to_char(cp.pc_region)               REGION						" +
		"	       ,cp.pc_mdn                           MDN							" +
		"	       ,cp.pc_esn_d                         ESN_D						" +
		"	       ,to_char(cp.pc_fec_rep,'dd-mm-yyyy') FEC_REP						" +
		"	       ,cp.pc_des_plan                      DES_PLAN					" +
		"	       ,cp.pc_modelo                        MODELO						" +
		"	       ,'$' || trim(to_char(cp.pc_precio_vta, '99,999,990.00'))   PRECIO_VTA 	" +
		"	       ,'$' || trim(to_char(cp.pc_comision,   '99,999,990.00'))   COMISION		" +
		"	       ,DECODE (cp.PC_ORIGEN_ACT, 'OTA','OTA','PRE', 'Preactivado', 'CTE', 'Cliente',  'Tellin') DESC_ORIGEN	" +
		"	       ,SI.POBKPNOMBRE                      POBLACION					" +
		"	       ,PC_DES_DIVISION                     DIVISION					" +
		"	       ,SE.EDODENOMBRE                      ESTADO						" +
		"	       ,cp.pc_num_factura                   NUM_FACTURA					" +
		"	       ,v.pc_desc_canal                     NOM_VENDEDOR 				" +
		"	from prodcm.pc_comis_prepago cp, prodcm.pc_origen_equipo op, 			" +
		"	     prodcm.pc_tipo_telefonia tt, prodcm.sircestados se, 				" +
		"	     prodcm.pc_divisiones d, prodcm.sirtseiseriesiusacell si,			" +
		"	     pc_canal  v,		 												" + //pc_canal 
		"		 pc_canal  v1														" + //pc_canal 
		"	where cp.pc_activ_mes = ?												" + // '201602' -- parametro 
		"	  and cp.pc_cve_origen = 1												" +
		"	  and cp.pc_cve_telef = 1												" +
		"	  and cp.pc_cve_origen = op.pc_cve_origen								" +
		"	  and cp.pc_cve_telef = tt.pc_cve_telef									" +
		"	  and SI.SERIE (+) = to_number(substr(cp.pc_mdn,1,6))					" +
		"	  and SI.RANGO_INI (+) <= to_number(substr(cp.pc_mdn,7,4))				" +
		"	  and SI.RANGO_FIN (+) >= to_number(substr(cp.pc_mdn,7,4))				" +
		"	  and SE.EDOCLCLAVE (+) = SI.EDOCLCLAVE 								" +
		"	  and  D.PC_CVE_DIVISION (+) = SI.PC_CVE_DIVISION						" +
		"	  and  v.pc_cve_canal = cp.pc_cve_canal									" +
		"	  and cp.id_seler = v1.pc_Cve_canal (+)									" ; */
	
	public static String PREPAGO_EQ_NUEVO =
		 "SELECT v.pc_desc_canal                      NOMBRE	" +                          
         ",cp.pc_activ_mes                     ACTIV_MEX	" +                      
         ",to_char(cp.pc_region)               REGION	" +                          
         ",cp.pc_mdn                           MDN	" +                              
         ",cp.pc_esn_d                         ESN_D	" +                          
         ",to_char(cp.pc_fec_rep,'dd-mm-yyyy') FEC_REP	" +                          
         ",cp.pc_des_plan                      DES_PLAN	" +                      
         ",cp.pc_modelo                        MODELO	" +                          
         ",'$' || trim(to_char(cp.pc_precio_vta, '99,999,990.00'))   PRECIO_VTA	" +       
         ",'$' || trim(to_char(cp.pc_comision,   '99,999,990.00'))   COMISION	" +          
         ",DECODE (cp.PC_ORIGEN_ACT, 'OTA','OTA','PRE', 'Preactivado', 'CTE', 'Cliente',  'Tellin') DESC_ORIGEN	" +      
         ",SI.POBKPNOMBRE                      POBLACION	" +                      
         ",PC_DES_DIVISION                     DIVISION	" +                      
         ",SE.EDODENOMBRE                      ESTADO	" +                          
         ",cp.pc_num_factura                   NUM_FACTURA	" +                      
         ",v.pc_desc_canal                     NOM_VENDEDOR	" +                   
		" FROM prodcm.pc_comis_prepago cp, prodcm.pc_origen_equipo op,	" +               
       "prodcm.pc_tipo_telefonia tt, prodcm.sircestados se,	" +                   
       "prodcm.pc_divisiones d, prodcm.sirtseiseriesiusacell si,	" +              
       "pc_canal@ESISCOM_CYC v,	" +                                                      
       "pc_canal@ESISCOM_CYC v1	" +                                                     
		" WHERE cp.pc_activ_mes = ?	" +                                             
		"AND cp.pc_cve_origen = 1	" +                                                  
		"AND cp.pc_cve_telef = 1	" +                                                  
		"AND cp.pc_cve_origen = op.pc_cve_origen	" +                                  
		"AND cp.pc_cve_telef = tt.pc_cve_telef	" +                                      
		"AND SI.SERIE (+) = to_number(substr(cp.pc_mdn,1,6))	" +                      
		"AND SI.RANGO_INI (+) <= to_number(substr(cp.pc_mdn,7,4))	" +                  
		"AND SI.RANGO_FIN (+) >= to_number(substr(cp.pc_mdn,7,4))	" +                  
		"AND SE.EDOCLCLAVE (+) = SI.EDOCLCLAVE	" +                                   
		"AND  D.PC_CVE_DIVISION (+) = SI.PC_CVE_DIVISION	" +                          
		"AND  v.pc_cve_canal = cp.pc_cve_canal	" +                                      
		"AND cp.id_seler = v1.pc_Cve_canal (+)";

	
	
	/*public static String PREPAGO_EQ_CAJON =
		"	select   v.pc_desc_canal             NOMBRE , 							" +
		"	        cp.pc_activ_mes             ACTIV_MES, 							" +
		"	        tecnologia                  CONCEPTO, 							" +
		"	        DECODE(ID_PARAMETRO 											" +
		"	          ,1, 'RETAIL' 													" +
		"	          ,2, 'EQUIPO NUEVO' 											" +
		"	          ,3, 'EQUIPO PROPIO' 											" +
		"	          ,4, 'PORTABILIDAD EXTERNA' 									" +
		"	        )                           TIPO_VENTA, 						" +
		"	        cp.pc_mdn                   MDN, 								" +
		"	        cp.pc_esn_d                 ESN_D, 								" +
		"	        to_char(cp.pc_fec_rep, 'dd-mm-yyyy') FEC_REP , 					" +
		"	        cp.pc_des_plan              DESC_PLAN, 							" +
		"	        cp.pc_modelo ,'$' || trim(to_char(cp.pc_precio_vta, '99,999,990.00' )) PRECIO_VTA,	" + 
		"	        cp.pc_num_factura           NUM_FACTURA, 						" +
		"	        DECODE (cp.PC_ORIGEN_ACT, 'OTA','OTA','PRE', 'Preactivado', 'CTE', 'Cliente',  'Tellin') DESC_ORIGEN ,	" + 
		"	        '$' || trim(to_char(cp.pc_comision,'99,999,990.00'))  COMISION 	" +
		"	 from prodcm.pc_comis_prepago  cp, 										" +
		"	      prodcm.pc_origen_equipo  op, 										" +
		"	      prodcm.pc_tipo_telefonia tt, 										" +
		"	      prodcm.sircestados       se, 										" +
		"	      prodcm.pc_divisiones     d, 										" +
		"	      prodcm.sirtseiseriesiusacell si, 									" +
		"	      pc_canal  v, 												" +
		"	      pc_canal  v1 												" +
		"	        where cp.pc_activ_mes       = ?									" + //'201602'       -- parametro 
		"	          and cp.pc_cve_origen      = 2 								" +
		"	          and cp.pc_cve_telef       = 1 								" +
		"	          and cp.pc_cve_origen      = op.pc_cve_origen				 	" +
		"	          and cp.pc_cve_telef       = tt.pc_cve_telef 					" +
		"	          and SI.SERIE (+)          = to_number(substr(cp.pc_mdn,1,6)) 	" +
		"	          and SI.RANGO_INI (+)      <= to_number(substr(cp.pc_mdn,7,4)) " +
		"	          and SI.RANGO_FIN (+)      >= to_number(substr(cp.pc_mdn,7,4)) " +
		"	          and SE.EDOCLCLAVE (+)     = SI.EDOCLCLAVE 					" +
		"	          and D.PC_CVE_DIVISION (+) = SI.PC_CVE_DIVISION 				" +
		"	          and v.pc_cve_canal        = cp.pc_cve_canal 					" +
		"	          and cp.id_seler           = v1.pc_Cve_canal (+)				" ; */
	
	public static String PREPAGO_EQ_CAJON =
		"SELECT   v.pc_desc_canal             NOMBRE ,	" +                               
        "cp.pc_activ_mes             ACTIV_MES,	" +                               
        "tecnologia                  CONCEPTO,	" +                               
        "DECODE(ID_PARAMETRO	" +                                               
         " ,1, 'RETAIL'	" +                                                       
         " ,2, 'EQUIPO NUEVO'	" +                                               
         " ,3, 'EQUIPO PROPIO'	" +                                               
         ",4, 'PORTABILIDAD EXTERNA'	" +                                       
        ")                           TIPO_VENTA,	" +                           
        "cp.pc_mdn                   MDN,	" +                                   
        "cp.pc_esn_d                 ESN_D,	" +                                   
        "to_char(cp.pc_fec_rep, 'dd-mm-yyyy') FEC_REP ,	" +                       
        "cp.pc_des_plan              DESC_PLAN,	" +                               
        "cp.pc_modelo ,'$' || trim(to_char(cp.pc_precio_vta, '99,999,990.00' )) PRECIO_VTA,	" +       
        "cp.pc_num_factura           NUM_FACTURA,	" +                           
        "DECODE (cp.PC_ORIGEN_ACT, 'OTA','OTA','PRE', 'Preactivado', 'CTE', 'Cliente',  'Tellin') DESC_ORIGEN ,	" +       
        "'$' || trim(to_char(cp.pc_comision,'99,999,990.00'))  COMISION	" +       
		"FROM prodcm.pc_comis_prepago  cp,	" +                                           
		"prodcm.pc_origen_equipo  op,	" +                                           
		"prodcm.pc_tipo_telefonia tt,	" +                                           
		"prodcm.sircestados       se,	" +                                           
		"prodcm.pc_divisiones     d,	" +                                           
		"prodcm.sirtseiseriesiusacell si,	" +                                       
		"pc_canal@ESISCOM_CYC v,	" +                                                   
		"pc_canal@ESISCOM_CYC v1	" +                                                   
        "WHERE cp.pc_activ_mes       = ? 	" +                                   
        "  AND cp.pc_cve_origen      = 2	" +                                   
        "  AND cp.pc_cve_telef       = 1	" +                                   
        "  AND cp.pc_cve_origen      = op.pc_cve_origen	" +                       
        "  AND cp.pc_cve_telef       = tt.pc_cve_telef	" +                       
        "  AND SI.SERIE (+)          = to_number(substr(cp.pc_mdn,1,6))	" +       
        "  AND SI.RANGO_INI (+)      <= to_number(substr(cp.pc_mdn,7,4))	" +   
        "  AND SI.RANGO_FIN (+)      >= to_number(substr(cp.pc_mdn,7,4))	" +   
        "  AND SE.EDOCLCLAVE (+)     = SI.EDOCLCLAVE	" +                       
        "  AND D.PC_CVE_DIVISION (+) = SI.PC_CVE_DIVISION	" +                   
        "  AND v.pc_cve_canal        = cp.pc_cve_canal	" +                       
        "  AND cp.id_seler           = v1.pc_Cve_canal (+)";	
	
	
	
	
	/*public static String COBRANZA =
		"select " +
		"	a.CDG_CIA,			" +
		"	a.CDG_CSI,			" +
		"	a.CDG_REGION,		" +
		"	a.NUM_TRANSACCION,	" +
		"	a.PC_CDG_CPTO_VTA,	" +
		"	a.PC_COBRANZA_MES,	" +
		"	a.PC_COMISION,		" +
		"	a.PC_CUSTOMER_ID,	" +
		"	a.PC_CVE_CANAL,		" +
		"	a.PC_CVE_ESQUEMA,	" +
		"	a.PC_CVE_VENDEDOR,	" +
		"	a.PC_DESC_CPTO,		" +
		"	a.PC_FEC_TRANS,		" +
		"	a.PC_MDN,			" +
		"	a.PC_MONTO,			" +
		"	a.PC_NOM_VEND,		" +
		"	a.PC_ORIGEN_EMP,	" +
		"	a.TIPO_TRANSACCION 	" +
		"from  prodcm.pc_comis_cobranza a where to_char(a.pc_fec_trans,'yyyymm') = ?"; */
	
	public static String COBRANZA =
		"SELECT " +   
        "a.CDG_CIA, " +              
        "a.CDG_CSI, " +              
        "a.CDG_REGION, " +          
        "a.NUM_TRANSACCION, " +      
        "a.PC_CDG_CPTO_VTA, " +      
        "a.PC_COBRANZA_MES, " +      
        "a.PC_COMISION, " +          
        "a.PC_CUSTOMER_ID, " +      
        "a.PC_CVE_CANAL, " +          
        "a.PC_CVE_ESQUEMA, " +      
        "a.PC_CVE_VENDEDOR, " +      
        "a.PC_DESC_CPTO, " +          
        "a.PC_FEC_TRANS, " +          
        "a.PC_MDN, " +              
        "a.PC_MONTO, " +              
        "a.PC_NOM_VEND, " +          
        "a.PC_ORIGEN_EMP, " +      
        "a.TIPO_TRANSACCION " +       
    " FROM  prodcm.pc_comis_cobranza a WHERE to_char(a.pc_fec_trans,'yyyymm') = ? " ;
	
	/*public static String CAES_ARSA =
		"	select 	CDG_CSI           CSI, 					" +
		"	        pc_nom_ptoventas  NOM_PTOVENTAS, 		" +
		"	        TRANS_DATE_TIME   DATE_TIME, 			" +
		"	        cdg_producto      PRODUCTO, 			" +
		"	        num_cel           NUM_CEL, 				" +
		"	        ABONO_ATM         ABONO_ATM				" +
		"	  from TIEMPOAIRE_LOG@ESISCOM_PORTREP  a,								" +
		"	       CLIECON.PC_PUNTO_VENTAS  b								" +
		"	 WHERE TRUNC(TRANS_DATE_TIME) BETWEEN TO_DATE(?, 'YYYYMMDD') 			" +//'01/02/2016'  -- parametro 1ero del mes
		"	                                  AND TO_DATE(?, 'YYYYMMDD')			" +//'29/02/2016'   -- parametro último de mes 
		"	   AND STATUS IN ('AC')													" +
		"	   and cdg_csi = b.pc_cve_ptoventas										" +
		"	   and cdg_csi  in ('R9-0074','R9-0287','R9-0073','R9-0513','R9-0531',	" +
		"	                    'R9-0527','R9-0555','R9-0556','R9-0557','R9-0056',	" +
		"	                    'R9-0088','R9-0295','R9-0298','R9-0300','R9-0301', 	" +
		"	                    'R9-0579')											" +
		"	order by 1, 3														" ; */
	
	public static String CAES_ARSA =
	 "SELECT     CDG_CSI           CSI,    		" +                   
     "pc_nom_ptoventas  NOM_PTOVENTAS,    		" +       
     "TRANS_DATE_TIME   DATE_TIME,        		" +       
     "cdg_producto      PRODUCTO,         		" +      
     "num_cel           NUM_CEL,          		" +         
     "ABONO_ATM         ABONO_ATM         		" +         
	 "FROM TIEMPOAIRE_LOG@ESISCOM_PORTAL  a, 	" +                                  
	 "CLIECON.PC_PUNTO_VENTAS@ESISCOM_CYC b    	" +                              
	 "WHERE TRUNC(TRANS_DATE_TIME) BETWEEN TO_DATE(?, 'YYYYMMDD')  	" +      
     "AND TO_DATE(?, 'YYYYMMDD')   	" +
	 "AND STATUS IN ('AC')             	" +                                         
	 "AND cdg_csi = b.pc_cve_ptoventas 	" +                                        
	 "AND cdg_csi  in ('R9-0074','R9-0287','R9-0073','R9-0513','R9-0531', 	" +      
     "'R9-0527','R9-0555','R9-0556','R9-0557','R9-0056',    				" +  
     "'R9-0088','R9-0295','R9-0298','R9-0300','R9-0301',       				" +
     "'R9-0579')                                              				" +
	 "ORDER BY 1, 3";

	
	/*public static String ADONS =
		" SELECT  					" +
		"	 a.ACCESSFEE,			" +
		"    a.CS_STAT_CHNG,		" +
		"    a.CUSTOMER_ID,			" +
		"	 a.DESCRIPCION,			" +
		"    a.DIAS_ALTA,			" +
		"    a.DIAS_BAJA,			" +
		"    a.FEC_ACT_SERV,		" +
		"    a.FEC_DESA_SERV,		" +
		"    a.NUM_CONTRATO,		" +
		"    a.NUM_TELEFONO,		" +
		"    a.PC_COMISION,			" +
		"    a.PC_CUENTA,			" +
		"    a.PC_CVE_CANAL,		" +
		"    a.PC_CVE_CONCEPTO,		" +
		"    a.PC_CVE_ESQUEMA,		" +
		"    a.PC_CVE_PAQUETE,		" +
		"    a.PC_DESC_CANAL,		" +
		"    a.PC_DESC_LARGA_PLAN,	" +
		"    a.PC_FECHA_VENTA,		" +
		"    a.PC_MES_PAGO,			" +
		"    a.PC_PLZ_FOR,			" +
		"    a.PC_PORC_DESC,		" +
		"    a.PC_PORC_DESC_ADI,	" +
		"    a.SNCODE 				" +
		"FROM prodcm.pc_comis_addons a WHERE TO_CHAR(a.PC_FECHA_VENTA, 'YYYYMM') = ?";*/
	
	public static String ADONS =
		 "SELECT          "+             
         "a.PC_CVE_CANAL,  "+ 
         "a.PC_DESC_CANAL ,  "+
         "a.NUM_CONTRATO ,  "+
         "a.NUM_TELEFONO ,  "+
         "a.PC_CVE_PAQUETE ,  "+
         "a.PC_DESC_LARGA_PLAN ,  "+
         "a.PC_FECHA_VENTA ,  "+
         "a.FEC_ACT_SERV ,  "+
         "a.FEC_DESA_SERV ,  "+
         "a.SNCODE ,  "+
         "a.DESCRIPCION ,  "+
         "a.ACCESSFEE ,  "+
         "a.PC_PORC_DESC ,  "+
         "a.PC_PORC_DESC_ADI ,  "+
         "a.PC_CUENTA ,  "+
         "a.CUSTOMER_ID ,  "+
         "a.PC_CVE_CONCEPTO ,  "+
         "a.PC_COMISION ,  "+
         "a.PC_CVE_ESQUEMA ,  "+
         "a.PC_PLZ_FOR  "+                 
		" FROM prodcm.pc_comis_addons a WHERE TO_CHAR(a.PC_FECHA_VENTA, 'YYYYMM') = ?";	
	
	
	
	
	/*public static String MOVIMIENTOS_ADONS =
		" SELECT  					" +
		"		CVE_SERV,			" +
		"		DESCRIPCION_SERV,	" +
		"		FEC_ACT_SERV,		" +
		"		FEC_DESAC_SERV,		" +
		"		NUM_CONTRATO,		" +
		"		NUM_TELEFONO,		" +
		"		PC_COMISION,		" +
		"		PC_COMISION_CHB,	" +
		"		PC_CONCEPTO,		" +
		"		PC_CVE_CANAL,		" +
		"		PC_CVE_PAQUETE,		" +
		"		PC_DESC_CANAL,		" +
		"		PC_DESC_LARGA_PLAN,	" +
		"		PC_DIAS_BAJA,		" +
		"		PC_DIAS_CUMPLIDOS,	" +
		"		PC_FECHA_VENTA,		" +
		"		PC_MES_BAJA,		" +
		"		PC_MES_PAGO,		" +
		"		PC_PORC_DESC,		" +
		"		PC_PORC_DESC_ADI,	" +
		"		PC_TIPO_MOVIMIENTO,	" +
		"		PLAZO,				" +
		"		RENTA_SERV 			" +		
		"FROM prodcm.pc_addons_mov a ";*/
	
	
	public static String MOVIMIENTOS_ADONS =
		  "SELECT	" +                       
          "a.PC_CVE_CANAL ,	" +
          "a.PC_DESC_CANAL ,	" +
          "a.PC_TIPO_MOVIMIENTO ,	" +
          "a.NUM_CONTRATO ,	" +
          "a.NUM_TELEFONO ,	" +
          "a.PC_CVE_PAQUETE ,	" +
          "a.PC_DESC_LARGA_PLAN ,	" +
          "a.PLAZO ,	" +
          "a.PC_FECHA_VENTA ,	" +
          "a.FEC_ACT_SERV ,	" +
          "a.FEC_DESAC_SERV ,	" +
          "a.PC_DIAS_BAJA ,	" +
          "a.PC_DIAS_CUMPLIDOS ,	" +
          "a.CVE_SERV ,	" +
          "a.DESCRIPCION_SERV ,	" +
          "a.RENTA_SERV ,	" +
          "a.PC_PORC_DESC ,	" +
          "a.PC_PORC_DESC_ADI ,	" +
          "a.PC_COMISION ,	" +
          "a.PC_COMISION_CHB ,	" +
          "a.PC_CONCEPTO ,	" +
          "a.PC_MES_PAGO ,	" +
          "a.PC_MES_BAJA	" +                 
		  " FROM prodcm.pc_addons_mov a ";
		
	
	/*public static String BAJAS_ADMINISTRATIVAS =
		" SELECT a.BB_CUENTA,				"+
		"		  a.BB_CVE_CANAL,			"+
		"		  a.BB_CVE_CONTRATO,		"+
		"		  a.BB_CVE_PLAN,			"+
		"		  a.BB_CVE_USUARIO,			"+
		"		  a.BB_ESN,					"+		
		"		  a.BB_FEC_ACT,				"+
		"		  a.BB_FEC_BAJA,			"+
		"		  a.BB_MDN,					"+
		"		  a.BB_MOV_ERRONEOS,		"+
		"		  a.BB_RAZON_MOVIMIENTO		"+
  		"	FROM  prodcm.COMI_BAJAS_POSP a									 "+
		" WHERE TO_CHAR(a.BB_FEC_BAJA,'YYYYMM') = ? 								 "+//'201602'  -- parametro 
		" AND  a.BB_MOV_ERRONEOS LIKE '%RENOV%' OR   a.BB_MOV_ERRONEOS LIKE  '%ACTIV%'";*/
	
	public static String BAJAS_ADMINISTRATIVAS=
           "SELECT  	"+       
           "a.BB_CVE_CONTRATO ,	"+
           "a.BB_CUENTA ,	"+
           "a.BB_FEC_BAJA ,	"+
           "a.BB_FEC_ACT ,	"+
           "a.BB_CVE_PLAN ,	"+
           "a.BB_CVE_CANAL ,	"+
           "a.BB_CVE_USUARIO ,	"+
           "a.BB_ESN ,	"+
           "a.BB_MDN ,	"+
           "a.BB_RAZON_MOVIMIENTO ,	"+
           "a.BB_MOV_ERRONEOS	"+       
           "  FROM  prodcm.COMI_BAJAS_POSP a	"+                                      
           " WHERE TO_CHAR(a.BB_FEC_BAJA,'YYYYMM') = ?	"+                                  
           "AND  a.BB_MOV_ERRONEOS LIKE '%RENOV%' OR   a.BB_MOV_ERRONEOS LIKE  '%ACTIV%'";
	
	/*public static String REPORTE_RESIDUALES =
		" select 							" +
		"		 a.CANAL_TP,				" +
		"        a.CLAVE_DIST_NUEVO,		" +
		"        a.CLAVE_DIST_ORIG,			" +
		"        a.COMISION,				" +
		"        a.CONTRATO,				" +
		"        a.DESCUENTO_ADICIONAL,		" +
		"        a.DESCUENTO_MULTILINEA,	" +
		"        a.ESTATUS_LINEA,			" +
		"        a.FECHA_ACTIVACION,		" +
		"        a.FECHA_FIN_PLAZO,			" +
		"        a.PC_CVE_CANAL,			" +
		"        a.PC_DESC_CANAL,			" +
		"        a.PC_DESC_LARGA_PLAN,		" +
		"        a.PC_DESC_TP_CANAL,		" +
		"        a.PC_NOM_PTOVENTAS,		" +
		"        a.PERIODO,					" +
		"        a.PLAN,					" +
		"        a.PLAZO_FORZOSO,			" +
		"        a.PUNTO_DE_VENTA,			" +
		"        a.RENTA,					" +
		"        a.TELEFONO,				" +
		"        a.TIPO_CLIENTE				" +
		"from prodcm.reporte_201512_res_04 a where a.periodo =? 	"; //201602 */
	
	public static String REPORTE_RESIDUALES =
	 "SELECT                        " +      
     "a.PC_CVE_CANAL ,				" +
     "a.PUNTO_DE_VENTA ,			" +
     "a.PLAN ,   					" +
     "a.RENTA ,						" +
     "a.CONTRATO ,      			" +
     "a.ESTATUS_LINEA ,				" +
     "a.DESCUENTO_MULTILINEA ,		" +
     "a.DESCUENTO_ADICIONAL ,   	" +
     "a.PLAZO_FORZOSO ,     		" +
     "a.FECHA_ACTIVACION ,     		" +
     "a.FECHA_FIN_PLAZO ,			" +
     "a.COMISION ,    				" +
     "a.PERIODO ,     				" +
     "a.CLAVE_DIST_ORIG ,      		" +
     "a.CLAVE_DIST_NUEVO ,      	" +
     "a.TIPO_CLIENTE ,           	" +
     "a.TELEFONO ,                	" +
     "a.PC_DESC_LARGA_PLAN ,     	" +
     "a.PC_DESC_CANAL ,				" +
     "a.CANAL_TP,               	" +
     "a.PC_DESC_TP_CANAL ,      	" +
     "a.PC_NOM_PTOVENTAS            " +     
	 "FROM prodcm.reporte_201505_res_04 a WHERE a.periodo = ? "; 
	
	
	
	
}
