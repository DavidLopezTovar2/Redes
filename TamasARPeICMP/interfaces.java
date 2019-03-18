
import java.util.List;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.NifSelector;


/**
 *
 * @author gabriel
 */
public class interfaces extends NifSelector {

    List<PcapNetworkInterface> p;

    public interfaces() throws PcapNativeException {
        this.p = Pcaps.findAllDevs();
    }
    
}
