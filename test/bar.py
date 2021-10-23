
import re
#from mock import patch, Mock

class NodeInfoMessage():
    node_id : int
    software_major_version : int
    software_minor_version : int
    hardware_major_version : int
    hardware_minor_version : int
    name : str

    def __init__(self, msg = None, **kwargs):
        if msg is not None:
            self.node_id = int(re.search("(?<=for node )[0-9]+",msg).group())
            self.software_major_version, self.software_minor_version = self.get_major_and_minor_version(re.search("(?<=software_version:)(?:(?!hardware_version)[\S\n\t\v ])*",msg).group())
            self.hardware_major_version, self.hardware_minor_version = self.get_major_and_minor_version(re.search("(?<=hardware_version:)(?:(?!name)[\S\n\t\v ])*", msg).group())
            self.name = (re.search("(?<=name: \")(?:(?!\")[\S])*", msg)).group()
        else:
            self.node_id = kwargs['node_id']
            self.software_major_version = kwargs['software_major_version']
            self.software_minor_version = kwargs['software_minor_version']
            self.hardware_major_version = kwargs['hardware_major_version']
            self.hardware_minor_version = kwargs['hardware_minor_version']
            self.name = kwargs["name"]

    def get_major_and_minor_version(self, msg):
        major_version = re.search("(?<=major: )[0-9]+", msg).group()
        minor_version = re.search("(?<=minor: )[0-9]+", msg).group()
        return int(major_version), int(minor_version)
        
    def __eq__(self, other):
        return self.node_id == other.node_id and self.software_major_version == other.software_major_version and self.software_minor_version == other.software_minor_version and self.hardware_major_version == other.hardware_major_version and self.hardware_minor_version == other.hardware_minor_version and self.name == other.name

    def __repr__(self):
        return f'Node Id: {self.node_id} software_major_version: {self.software_major_version} software_minor_version: {self.software_minor_version} hardware_major_version: {self.hardware_major_version} hardware_minor_version: {self.hardware_minor_version} name: {self.name}'

node = [NodeInfoMessage(r"""Node Info for node 120\n----------------------\nstatus: \n  uptime_sec: 0\n  health: 0\n  mode: 0\n  \ sub_mode: 0\n vendor_specific_status_code: 0\nsoftware_version: \n  major: 0\n  minor: 0\n  optional_field_flags: 0\n  
        vcs_commit: 0\n  image_crc: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\nhardware_version: \n  
        major: 0\n  minor: 0\n  unique_id: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n  certificate_of_authenticity: ""\nname: "ADS_measurements_reader0"\n----------------------""")
        ,NodeInfoMessage(r"""Node Info for node 2\n----------------------\nstatus: \n  uptime_sec: 1\n  health: 0\n  mode: 0\n  sub_mode: 0\n  vendor_specific_status_code: 0\nsoftware_version: \n  major: 0\n  minor: 0\n  optional_field_flags: 0\n  
        vcs_commit: 0\n  image_crc: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\nhardware_version: \n  
        major: 0\n  minor: 0\n  unique_id: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n  certificate_of_authenticity: ""\nname: "com.amazon.sync_broadcaster"\n----------------------"""),
        NodeInfoMessage(r"""Node Info for node 45\n----------------------\nstatus: \n  uptime_sec: 0\n  health: 1\n  mode: 0\n  sub_mode: 0\n  vendor_specific_status_code: 0\nsoftware_version: \n  major: 1\n  minor: 3\n  optional_field_flags: 3\n  
        vcs_commit: 2692944494592\n  image_crc: [104, 6, 29, 143, 168, 5, 231, 206, 123, 13, 255, 60, 131, 212, 111, 162, 107, 226, 198, 167, 196, 59, 17, 114, 25, 224, 126, 17, 68, 230, 1, 248]\nhardware_version: \n  
        major: 1\n  minor: 0\n  unique_id: [34, 144, 135, 32, 84, 16, 4, 129, 120, 0, 160, 0, 160, 0, 0, 105]\n  certificate_of_authenticity: ""\nname: "com.amazon.ads-traq"\n----------------------""")]
node1 = [
        NodeInfoMessage(node_id = 120, software_major_version = 0, software_minor_version = 0, hardware_major_version = 0, hardware_minor_version = 0, name = "ADS_measurements_reader0" ),
        NodeInfoMessage(node_id = 2, software_major_version = 0, software_minor_version = 0, hardware_major_version = 0, hardware_minor_version = 0, name = "com.amazon.sync_broadcaster"),
        NodeInfoMessage(node_id = 45, software_major_version = 1, software_minor_version = 3, hardware_major_version = 1, hardware_minor_version = 0, name = "com.amazon.ads-traq")
    ]
print(node1, "dfsdfsd", node)
assert (node == [
        NodeInfoMessage(node_id = 120, software_major_version = 0, software_minor_version = 0, hardware_major_version = 0, hardware_minor_version = 0, name = "ADS_measurements_reader0" ),
        NodeInfoMessage(node_id = 2, software_major_version = 0, software_minor_version = 0, hardware_major_version = 0, hardware_minor_version = 0, name = "com.amazon.sync_broadcaster"),
        NodeInfoMessage(node_id = 45, software_major_version = 1, software_minor_version = 3, hardware_major_version = 1, hardware_minor_version = 0, name = "com.amazon.ads-traq")
    ])

#import re

#txt = "The rain in Spain"
#x = re.split("^The", txt)
#print(x)