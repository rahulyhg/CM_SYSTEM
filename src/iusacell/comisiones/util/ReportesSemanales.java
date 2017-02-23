package iusacell.comisiones.util;

public class ReportesSemanales {
		
	 
	public static String ACTIVACIONES =
	"SELECT  pa.cdg_region  REGION,						   					"+                     
    "pc.pc_Cve_paquete                        CVE_PAQUETE, 					"+             
    "pc_desc_larga_plan                  DESC_LARGA_PLAN,  					"+         
    "PC.PC_CVE_CANAL                          CVE_CANAL,   					"+               
    "CV.pc_DESC_CANAL                      DESC_CANAL,     					"+             
    "pa.cve_contrato                       CVE_CONTRATO,   					"+           
    "pa.custcode                              CUSTCODE,    					"+              
    "pa.nombre_usua||' '||pa.pater_usua||' '||pa.mater_usua NOMBRE_USUA,  	"+
    "esn                                        ESN,        				"+              
    "num_telefono                            NUM_TELEFONO,     				"+         
    "'Pospago'                                 CVE_GPO,           			"+       
    "TO_CHAR(fec_alta_cliente, 'dd/mm/yyyy') FEC_ALTA_CLIENTE,       		"+   
    "plazo_for                                PLAZO_FOR,                	"+  
    "PC.PC_MONTO_ACTIV                        MONTO_ACTIV,        			"+      
    "SI.POBKPNOMBRE                            POBKNOMBRE,           		"+       
    "PC_DES_DIVISION                            DES_DIVISION,           	"+   
    "SE.EDODENOMBRE                            EDODENOMBRE,              	"+
    "PA.PC_RENTA                                RENTA,              		"+        
    "DECODE(PC.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL')     ORIGEN_EMP   		"+   
    "FROM PRODCM.PARAM_ACT pa,                      						"+
    "PRODCM.PC_COMIS_VENTAS pc,              								"+
    "PRODCM.PC_PAQUETES_MAESTRO pm,           								"+
    "PRODCM.SIRTSEISERIESIUSACELL SI,          								"+
    "PRODCM.SIRCESTADOS SE,                  								"+
    "PRODCM.PC_DIVISIONES D,                  								"+
    "pc_canal@CLIECONP  CV           						           	    "+           
    "WHERE pa.CDG_CIA = PC.CDG_CIA                 							"+
    "AND pa.NUM_TRANSACCION = PC.NUM_TRANSACCION				      		"+
    "AND pa.TIPO_TRANSACCION = PC.TIPO_TRANSACCION      					"+
    "AND pa.NUM_CONTRATO    = PC.NUM_CONTRATO      							"+
    "AND pa.CDG_REGION = PC.CDG_REGION              						"+
    "AND pa.CDG_CSI = PC.CDG_CSI                   							"+
    "AND pc.pc_cve_paquete = pm.pc_cve_paquete      						"+
    "AND  SI.SERIE(+) = TO_NUMBER(SUBSTR(PA.num_telefono,1,6))  			"+         
    "AND  SI.RANGO_INI(+) <= TO_NUMBER(SUBSTR(PA.num_telefono,7,4))   		"+     
    "AND  SI.RANGO_FIN(+) >= TO_NUMBER(SUBSTR(PA.num_telefono,7,4))      	"+
    "AND  SE.EDOCLCLAVE(+) = SI.EDOCLCLAVE          						"+
    "AND  D.PC_CVE_DIVISION(+) = SI.PC_CVE_DIVISION    						"+  
    "AND PC.PC_CVE_CANAL = CV.PC_CVE_CANAL          						"+
    "AND PA.fec_alta_cliente >= TO_DATE( ? ||' 000000','YYYYMMDD HH24MISS') "+   
    "AND PA.fec_alta_cliente <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS') "+
    "ORDER BY 1 DESC" ;
	
	
	public static String RENOVACIONES =
		"SELECT   pa.cdg_region                            REGION,				" +                     
        "pc.pc_Cve_paquete                        CVE_PAQUETE,					" +
        "pc_desc_larga_plan                        DESC_LARGA_PLAN,				" +         
        "PC.PC_CVE_CANAL                            CVE_CANAL,					" +                 
        "CV.pc_DESC_CANAL                        DESC_CANAL,					" +                 
        "TO_CHAR(PA.FEC_ACTIVACION, 'dd/mm/yyyy') FEC_ACTIVACION,				" +         
        "pc_fecha_renova                            FECHA_RENOVA,				" +             
        "pa.cve_contrato                            CVE_CONTRATO,				" +             
        "pa.custcode                                CUSTCODE,					" +                 
        "pa.nombre_usua||' '||pa.pater_usua||' '||pa.mater_usua NOMBRE_USUA,	" + 
        "esn                                        ESN,						" +                     
        "num_telefono                            NUM_TELEFONO,					" +             
        "plazo_for                                PLAZO_FOR,					" +                 
        "PC.PC_MONTO_renova                        MONTO_RENOVA,				" +             
        "SI.POBKPNOMBRE                            POBKPNOMBRE,					" +             
        "PC_DES_DIVISION                            DES_DIVISION,				" +             
        "SE.EDODENOMBRE                            EDODENOMBRE,					" +             
        "pa.pc_renta                                RENTA,						" +                     
        "DECODE(PC.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL')     ORIGEN_EMP		" +     
        "FROM                                									" +
        "prodcm.PARAM_ACT pa,             										" +
        "prodcm.PC_COMIS_RENOVACIONES pc, 										" +
        "prodcm.PC_PAQUETES_MAESTRO pm,     									" +
        "prodcm.SIRTSEISERIESIUSACELL SI, 										" +
        "prodcm.SIRCESTADOS SE,             									" +
        "prodcm.PC_DIVISIONES D,             									" +
        "pc_canal@CLIECONP  CV                     							    " +
        "WHERE pa.CDG_CIA = PC.CDG_CIA         									" +
        "AND pa.NUM_TRANSACCION    = PC.NUM_TRANSACCION    						" + 
        "AND pa.TIPO_TRANSACCION = PC.TIPO_TRANSACCION     						" +
        "AND pa.NUM_CONTRATO = PC.NUM_CONTRATO             						" +
        "AND pa.CDG_REGION = PC.CDG_REGION                 						" +
        "AND pa.CDG_CSI = PC.CDG_CSI                         					" +
        "AND pc.pc_cve_paquete = pm.pc_cve_paquete         						" +
        "AND SI.SERIE (+)  = TO_NUMBER(SUBSTR(PA.num_telefono,1,6))    			" + 
        "AND SI.RANGO_INI (+)  <= TO_NUMBER(SUBSTR(PA.num_telefono,7,4)) 		" +    
        "AND SI.RANGO_FIN (+) >= TO_NUMBER(SUBSTR(PA.num_telefono,7,4))     	" + 
        "AND SE.EDOCLCLAVE (+) = SI.EDOCLCLAVE             						" +
        "AND D.PC_CVE_DIVISION (+)  = SI.PC_CVE_DIVISION     					" +
        "AND PC.PC_CVE_CANAL = CV.PC_CVE_CANAL             						" +
        "AND Pc.pc_fecha_renova >= TO_DATE( ? ||' 000000','YYYYMMDD HH24MISS')	" + 
        "AND pc.pc_fecha_renova <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS')	" +
        "ORDER BY 1 DESC ";	
	
		
	
	public static String BAJAS_ACTIVACIONES =
		"SELECT pc.cdg_region                            REGION,   	" +               
        "pa.cdg_plan_uso                            PLAN_USO,      	" +       
        "pc_desc_larga_plan                        DESC_LARGA_PLAN,	" +    
        "PC.PC_CVE_canal                            CVE_CANAL,     	" +        
        "CV.pc_desc_canal                            DESC_CANAL,   	" +         
        "pc.pc_cve_contrato                        CVE_CONTRATO,   	" +      
        "pc.pc_cuenta                                CUENTA,      	" +           
        "num_telefono                                NUM_TELEFONO, 	" +        
        "TO_CHAR(pc_fecha_venta, 'dd/mm/yyyy')     FECHA_VENTA,    	" +     
        "TO_CHAR(pc_fecha_baja, 'dd/mm/yyyy')     FECHA_BAJA,     	" +        
        "To_char(TRUNC(pc_fecha_baja - pc_fecha_venta))    DIAS_DIFF,	" +     
        "to_char(pc_monto_act + pc_monto_resid)    SUMA_MONTOS,    	" +     
        "si.pobkpnombre                            POBKPNOMBRE,    	" +     
        "pc_des_division                            DES_DIVISION,  	" +       
        "se.edodenombre                            EDODENOMBRE,    	" +     
        "decode(pc.PC_ORIGEN_EQPO, 1, 'IUSACELL','CAJON')    ORIGEN_EQPO, 	" + 
        "PC_MONTO_EQPO                            MONTO_EQPO,     	" +        
        "DECODE(PA.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL')    ORIGEN_EMP 	" +    
		"FROM prodcm.PARAM_ACT pa,    	" +         
		"prodcm.PC_COMIS_BAJAS pc,     	" +    
		"prodcm.PC_PAQUETES_MAESTRO pm, " +    
		"prodcm.SIRTSEISERIESIUSACELL SI, 	" +    
		"prodcm.SIRCESTADOS SE,            	" +
		"prodcm.PC_DIVISIONES D,       		" +
		"pc_canal@CLIECONP CV          	" +
		"WHERE pc.pc_Fecha_baja >= TO_DATE( ? ||' 000000','YYYYMMDD HH24MISS') 	" +      
		"AND pc.pc_Fecha_baja <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS')	" +      
		"AND pa.cdg_cia = pc.cdg_cia         									" +
		"AND pa.num_transaccion    = pc.num_transaccion     					" +
		"AND pa.tipo_transaccion = pc.tipo_transaccion     						" +
		"AND pa.num_contrato    = pc.num_contrato         						" +
		"AND pa.cdg_region = pc.cdg_region                 						" +
		"AND pa.cdg_csi = pc.cdg_csi                        					" + 
		"AND pa.cdg_plan_uso = pm.pc_cve_paquete             					" +
		"and pc.pc_orig_baja = 'AC'                         					" +
		"AND  si.serie (+)= TO_NUMBER(SUBSTR(pa.num_telefono,1,6))     			" +
		"AND  si.rango_ini(+) <= TO_NUMBER(SUBSTR(pa.num_telefono,7,4))     	" +
		"AND  si.rango_fin (+)>= TO_NUMBER(SUBSTR(pa.num_telefono,7,4))     	" +
		"AND  se.edoclclave(+) = si.edoclclave             						" +
		"AND  d.pc_cve_division(+) = si.pc_cve_division     					" +
		"AND pc.pc_cve_canal = CV.pc_cve_canal             						" +
		"ORDER BY 1 DESC" ;   
	 
	
			
	public static String BAJAS_RENOVACIONES=
        "SELECT pc.cdg_region                            REGION, 				" +                
        "      pa.cdg_plan_uso                            PLAN_USO,				" +             
        "       pc_desc_larga_plan                        DESC_LARGA_PLAN,		" +     
        "       PC.PC_CVE_canal                            CVE_CANAL,			" +             
        "       CV.pc_desc_canal                            DESC_CANAL,			" +             
        "       pc.pc_cve_contrato                        CVE_CONTRATO,			" +         
        "       pc.pc_cuenta                                CUENTA,				" +                 
        "       num_telefono                                NUM_TELEFONO,		" +         
        "       TO_CHAR(pc_fecha_venta, 'dd/mm/yyyy')     FECHA_VENTA,			" +         
        "       TO_CHAR(pc_fecha_baja, 'dd/mm/yyyy')     FECHA_BAJA,			" +             
        "       To_char(TRUNC(pc_fecha_baja - pc_fecha_venta))    DIAS_DIFF,	" +     
        "       to_char(pc_monto_act + pc_monto_resid)    SUMA_MONTOS,			" +         
        "       si.pobkpnombre                            POBKPNOMBNRE,			" +         
        "       pc_des_division                            DES_DIVISION,		" +         
        "       se.edodenombre                            EDODENOMBRE,			" +         
        "       decode(pc.PC_ORIGEN_EQPO, 1, 'IUSACELL','CAJON') ORIGEN_EQPO,	" + 
        "       PC_MONTO_EQPO                            MONTO_EQPO, 			" +            
        "       DECODE(PA.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL') ORIGEN_EMP		" +     
        "		FROM prodcm.PARAM_ACT pa,										" +                             
        "     prodcm.PC_COMIS_BAJAS pc,											" +                         
        "     prodcm.PC_PAQUETES_MAESTRO pm,									" +                     
        "     prodcm.SIRTSEISERIESIUSACELL SI,									" +                 
        "     prodcm.SIRCESTADOS SE, 											" +                            
        "     prodcm.PC_DIVISIONES D, 											" +                        
        "     pc_canal@CLIECONP  CV 											" +                                    
        "WHERE pc.pc_Fecha_baja >= TO_DATE(  ? ||' 000000','YYYYMMDD HH24MISS')	" +   
        "	AND pc.pc_Fecha_baja <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS')	" + 
        "    AND pa.cdg_cia = pc.cdg_cia										" +                         
        "    AND pa.num_transaccion    = pc.num_transaccion						" +     
        "    AND pa.tipo_transaccion = pc.tipo_transaccion						" +     
        "    AND pa.num_contrato    = pc.num_contrato							" +         
        "    AND pa.cdg_region = pc.cdg_region									" +                 
        "    AND pa.cdg_csi = pc.cdg_csi										" +                         
        "    AND pa.cdg_plan_uso = pm.pc_cve_paquete							" +             
        "    and pc.pc_orig_baja = 'RE'											" +                         
        "    AND  si.serie (+)= TO_NUMBER(SUBSTR(pa.num_telefono,1,6))			" +     
        "    AND  si.rango_ini(+) <= TO_NUMBER(SUBSTR(pa.num_telefono,7,4))		" +     
        "    AND  si.rango_fin (+)>= TO_NUMBER(SUBSTR(pa.num_telefono,7,4))		" +     
        "    AND  se.edoclclave(+) = si.edoclclave								" +             
        "    AND  d.pc_cve_division(+) = si.pc_cve_division						" +     
        "    AND pc.pc_cve_canal = CV.pc_cve_canal								" +             
        "ORDER BY 1 DESC" ; 
	
	
	
	public static String COBRANZA =
		 "SELECT c.cdg_region                                REGION,		" +                 
         "c.cdg_csi                                CSI, 					" +                
         "CV.pc_desc_canal                            DESC_CANAL,			" +             
         "c.pc_cve_canal                            CVE_CANAL, 				" +            
         "SUM(c.pc_monto)                             MONTO,				" +                 
         "SUM(pc_comision)                         COMISION,				" +             
         "pc_desc_cpto                                DESC_CPTO,  			" +
         "pc_cdg_cpto_vta PC_CDG_CPTO_VTA, 									" +
         "si.pobkpnombre                            POBKPNOMBRE, 			" +         
         "pc_des_division                            DES_DIVISION,			" +         
         "se.edodenombre                            EDODENOMBRE, 			" +        
         "DECODE(C.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL') ORIGEN_EMP		" +               
		 "FROM prodcm.PC_COMIS_COBRANZA c,									" +          
         "pc_canal@CLIECONP CV,												" +                         
         "prodcm.SIRTSEISERIESIUSACELL si,									" +     
         "prodcm.SIRCESTADOS se, 											" +                
         "prodcm.PC_DIVISIONES d											" +                      
	     "WHERE pc_fec_trans >= TO_DATE( ? ||' 000000','YYYYMMDD HH24MISS')	" +       
         "AND   pc_fec_trans <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS')	" +   
         "AND   CV.pc_cve_canal = c.pc_cve_canal							" +                     
         "AND  pc_monto > 0													" +                                         
         "AND  TO_CHAR(si.serie(+)) = SUBSTR(c.pc_mdn,1,6)					" +    
         "AND  si.rango_ini(+) <= TO_NUMBER(SUBSTR(c.pc_mdn,7,4))			" +     
         "AND  si.rango_fin(+) >= TO_NUMBER(SUBSTR(c.pc_mdn,7,4))			" +     
         "AND  se.edoclclave(+) = si.edoclclave								" +                     
         "AND  d.pc_cve_division(+) = si.pc_cve_division					" +              
	     "GROUP BY c.pc_cve_canal, CV.pc_desc_canal, pc_desc_cpto,pc_cdg_cpto_vta,	" + 
	     "c.cdg_region, c.cdg_csi, si.pobkpnombre, pc_des_division, se.edodenombre	" +      
	     ",DECODE(C.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL')					" +             
	     "ORDER BY 1 DESC" ;
		
	
	public static String PREPAGO =
		 "SELECT  cp.PC_REGION                            REGION,					" +                 
         "cp.PC_CVE_canal                            CVE_CANAL,						" +             
         "V.PC_desc_canal                            DESC_CANAL,					" +             
         "cp.pc_mdn                                MDN,								" +                 
         "pc_esn_d                                ESN_D,							" +                 
         "TO_CHAR(cp.PC_FEC_REP,'dd/mm/yyyy')     FEC_REP,							" +             
         "tt.PC_DESCRIPCION                        DESCRIPCION_TT,					" +         
         "TiO.PC_DESCRIPCION                        DESCRIPCION_OEQ,				" +     
         "cp.pc_modelo                            MODELO,							" +                 
         "cp.PC_des_PLAN                            DES_PLAN,						" +             
         "cp.PC_PRECIO_VTA                        PRECIO_VTA, 						" +            
         "cp.pc_comision                            COMISION, 						" +            
         "cp.PC_NUM_FACTURA                        NUM_FACTURA, 					" +        
         "DECODE(CP.PC_ORIGEN_EMP,'U','UNEFON','IUSACELL') ORIGEN_EMP				" +             
		 "FROM PRODCM.PC_COMIS_PREPAGO cp,											" +             
		"PRODCM.PC_ORIGEN_EQUIPO TiO, 												" +         
		"PRODCM.PC_TIPO_TELEFONIA tt,												" +         
		"pc_canal@CLIECONP V														" +                             
		"WHERE  cp.PC_FEC_REP >= TO_DATE( ? ||' 000000','YYYYMMDD HH24MISS') 		" +  
		"AND cp.PC_FEC_REP <= TO_DATE( ? ||' 235959','YYYYMMDD HH24MISS') 			" +  
		"AND cp.pc_cve_telef = tt.pc_cve_telef 										" +    
		"AND cp.pc_cve_origen = TiO.pc_cve_origen  									" +
		"AND cp.pc_cve_CANAL = V.pc_cve_CANAL 										" +       
		"ORDER BY 1 DESC" ; 
	
	public static String REPORTE_PORTABILIDAD = 
		"	select 	fl.mdn				" +
		"					MDN, 				" +
		"			fl.mdn_provisional						MDN_PROVISIONAL,	" +
		"			fl.fecha_portado 						FECHA_PORTADO		" +
		"	from soaportal.soa_folio_lineas@ESISCOM_PORTREP fl, 				" +
		"	     soaportal.soa_recepciones@ESISCOM_PORTREP r					" +
		"	where fl.port_id in(												" +
		"          select to_char(port_id) 										" +
		"              	from soaportal.soa_solicitudes@ESISCOM_PORTREP		  	" +
		"          where trunc(fecha_creacion) >= to_date (?,'DD/MM/YYYY') 	  	" + //PARAMETRO '11/01/2016'
		"              	and trunc(fecha_creacion) <= to_date (?,'DD/MM/YYYY') 	" + //PARAMETRO '31/01/2016' 
		"               and tipo_port_id <> 8						" +
		"               and tipo_solicitud_id in (2,3)				" +
		"               and estatus_id = 4							" +
		"          )												" +
		"	  and fl.port_id =  r.port_id";
	
}
