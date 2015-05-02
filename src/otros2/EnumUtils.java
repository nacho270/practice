package otros2;

import java.util.HashMap;
import java.util.Map;

public class EnumUtils {

	public  static <K extends Number,V extends Enum<V> & CosaConId<K>> Map<K,V> getMapFromEnum (Class<V> eClass){
		Map<K,V> map = new HashMap<K, V>();
		V[] evalues= eClass.getEnumConstants();
		for (int i=0;i<evalues.length;i++){
			map.put( ((CosaConId<K>)evalues[i]).getId() , evalues[i]);
		}
		return map;
	}

	public static class EnumCache<K extends Number,V extends Enum<V> & CosaConId<K>> {
		
		private Class<V> myEnum;
		
		public EnumCache (Class<V> myEnum){
			this.myEnum = myEnum;
		}
		
		public V getById(K id) {
			V enumValue = getKeyMap().get(id);
			if (enumValue == null)
				throw new IllegalArgumentException(	"No existe un valor del enum para el identificador " + id);
			return enumValue;
		}
		private Map<K, V> keyMap;

		private Map<K, V> getKeyMap() {
			if (keyMap == null) {
				keyMap = EnumUtils.getMapFromEnum(this.myEnum);
			}
			return keyMap;
		}
	}
	
	/* USO
	private static EnumCache<Integer, UnEnum> eCache = new EnumUtils.EnumCache<Integer, UnEnum>(UnEnum.class);
	
	public static UnEnum getById(Integer id) {
		return eCache.getById(id);
	}

	*/
	
	/**
	 * Guarda, no es lo mas eficiente, pero es muy cómodo y claro
	 * @param values
	 * @return
	 */
	public static <T extends Enum<T>> boolean in ( Enum<T> oThis,  Enum<T>[] values){
		for (int i= 0;i< values.length;i++){
			if (values[i] == oThis ){
				return true;
			}
		}
		return false;
	}
}
